package cn.boxfish.jsp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoLiBing on 15/8/6.
 */
@Controller
public class JspController {

    @RequestMapping(value = "/index")
    public String index() {
        System.out.println(data);
        System.out.println("index");
        return "index";
    }

    @Value("${data}")
    String data;

}
