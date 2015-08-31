package cn.boxfish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoLiBing on 15/8/31.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }
}
