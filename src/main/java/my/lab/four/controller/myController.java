package my.lab.four.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import my.lab.four.entity.Point;
import my.lab.four.entity.User;
import my.lab.four.security.AuthProviderImpl;
import my.lab.four.service.PointService;
import my.lab.four.service.UserService;
import my.lab.four.service.impl.AuthServiceImpl;
import my.lab.four.util.EmailServiceImpl;
import my.lab.four.util.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@ComponentScan("my.lab.four")
public class myController {

    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    private PointService pointService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthProviderImpl authProvider;


    //Обработчик для входа в аккаунт
    @RequestMapping("/")
    public ModelAndView login( Model model){
        return new ModelAndView("login","user", new User());
    }

    //Обработчик для входа в аккаунт
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView signIn( Model model) {
        return new ModelAndView("login", "user", new User());
    }

    //Переход на главную страницу
    @RequestMapping( value = "/main")
    public ModelAndView entrece(@ModelAttribute("user") User user, HttpServletRequest request, Model model){
        //Нужна Валидация юзера
       User currentUser = (User) org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       emailService.sendPassword(currentUser.getMail());
       return new ModelAndView("main", "command", new Point());
    }


    //Работа с добавлением точки
    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public String addPoint(@ModelAttribute Point point, Model model){
        pointService.addPoint(point);
//        model.addAttribute("user",userService.getUser(currentUser.getCurrentMail()));
        model.addAttribute("points", pointService.getAll());
        model.addAttribute("command", new Point());
        return "main";
    }
}
