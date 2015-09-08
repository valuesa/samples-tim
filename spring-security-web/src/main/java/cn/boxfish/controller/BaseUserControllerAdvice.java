package cn.boxfish.controller;


import cn.boxfish.entity.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by LuoLiBing on 15/8/31.
 */
/*@ControllerAdvice
public class BaseUserControllerAdvice {

    // 每次都会进行判断
    @ModelAttribute("currentUser")
    public CurrentUser getBaseUser(Authentication authentication) {
        return (authentication == null) ? null: (CurrentUser) authentication.getPrincipal();
    }
}*/
