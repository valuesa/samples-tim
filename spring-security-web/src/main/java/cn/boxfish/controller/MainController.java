package cn.boxfish.controller;

/**
 * Created by TIM on 2015/8/30.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }
}
