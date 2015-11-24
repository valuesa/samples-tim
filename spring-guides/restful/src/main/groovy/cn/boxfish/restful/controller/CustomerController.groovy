package cn.boxfish.restful.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest

/**
 * Created by LuoLiBing on 15/10/15.
 */
@RequestMapping
@Controller
class CustomerController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        return "success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(String base, HttpServletRequest request) {
        def map = request.getParameterMap()
        println map
        println base
        return "aaaa"
    }
}
