package my.lab.four.controller;

import my.lab.four.entity.Point;
import my.lab.four.entity.User;
import my.lab.four.service.impl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class myController {

    @Autowired
    private PointServiceImpl pointService;

    @RequestMapping("/")
    public String login(Model model){
        model.addAttribute("command", new User());
        return "login";
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST)
    public String entrece(@ModelAttribute User user, Model model){
        System.out.println(user.getMail());
        model.addAttribute("mail", user.getMail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("command", new Point());
        return "main";
    }

    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public String addPoint(@ModelAttribute Point point, Model model){
        pointService.addPoint(point);
        model.addAttribute("x",point.getX());
        model.addAttribute("y", point.getY());
        model.addAttribute("R", point.getR());
        model.addAttribute("command", new Point());
        return "main";
    }
}
