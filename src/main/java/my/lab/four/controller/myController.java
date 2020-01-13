package my.lab.four.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import my.lab.four.entity.Point;
import my.lab.four.entity.User;
import my.lab.four.service.impl.PointServiceImpl;
import my.lab.four.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class myController {

    private String currentUser;

    @Autowired
    private PointServiceImpl pointService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public ModelAndView login(Model model){
        return new ModelAndView("login","users", new User());
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST)
    public ModelAndView entrece(@ModelAttribute User user, Model model){
        //Нужна Валидация юзера
        currentUser = user.getMail();
        userService.addUser(user);
        model.addAttribute("mail", user.getMail());
        model.addAttribute("password", user.getPassword());
        return new ModelAndView("main", "command", new Point());
    }

    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public String addPoint(@ModelAttribute Point point, Model model){
        pointService.addPoint(point);
        model.addAttribute("user",userService.getUser(currentUser));
        model.addAttribute("points", pointService.getAll());
        model.addAttribute("command", new Point());
        return "main";
    }
}
