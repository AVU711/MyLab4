package my.lab.four.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import my.lab.four.entity.Point;
import my.lab.four.entity.User;
import my.lab.four.service.impl.PointServiceImpl;
import my.lab.four.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SAAJResult;

@Controller
public class myController {

    private String currentUser;

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    private PointServiceImpl pointService;

    @Autowired
    private UserServiceImpl userService;


    //Обработчик для входа в аккаунт
    @RequestMapping("/")
    public ModelAndView login(Model model){
        return new ModelAndView("login","users", new User());
    }

    //Обработчик для входа в аккаунт
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView signIn(Model model) {
        return new ModelAndView("login", "users", new User());
    }

    //Переход на главную страницу
    @RequestMapping( value = "/login", method = RequestMethod.POST)
    public ModelAndView entrece(@ModelAttribute User user, HttpServletRequest request, Model model){
        //Нужна Валидация юзера
        currentUser = user.getMail();
        sendMessage(user.getMail());
        return new ModelAndView("main", "command", new Point());
    }

    //Переход на страницу регистрации
    @RequestMapping(name = "/myLab4/registration", method = RequestMethod.GET)
    public ModelAndView sign(Model model){
        return new ModelAndView("Registr", "users", new User());
    }

    @RequestMapping(name = "/myLab4/registration", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute User user, Model model){
        //Вывод сообщения о том, что письмо на почту пришло
        currentUser = user.getMail();
        sendMessage(user.getMail());
        user.setPassword("1234");
        userService.addUser(user);
        return new ModelAndView("login", "users", new Point());
    }

    //Работа с добавлением точки
    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public String addPoint(@ModelAttribute Point point, Model model){
        pointService.addPoint(point);
        model.addAttribute("user",userService.getUser(currentUser));
        model.addAttribute("points", pointService.getAll());
        model.addAttribute("command", new Point());
        return "main";
    }

    private void sendMessage(String adress){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(adress);
        message.setSubject("Регистрация");
        message.setText("Ваш пароль : 1234");
        javaMailSender.send(message);
    }
}
