package cn.boxfish.validate.controller;

import cn.boxfish.validate.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by LuoLiBing on 15/10/8.
 */
@Controller
public class ValidateController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Person person) {
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        // 绑定,校验查看是否有教研错误
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }
}
