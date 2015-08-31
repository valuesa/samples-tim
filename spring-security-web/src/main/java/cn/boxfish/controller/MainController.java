package cn.boxfish.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by TIM on 2015/8/30.
 */
@Controller
public class MainController {

    //@PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/")
    public String getHomePage(Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }
}
