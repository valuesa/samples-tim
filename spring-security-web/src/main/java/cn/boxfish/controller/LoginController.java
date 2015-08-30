package cn.boxfish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by LuoLiBing on 15/8/29.
 */
@Controller
public class LoginController {

    public String getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

}
