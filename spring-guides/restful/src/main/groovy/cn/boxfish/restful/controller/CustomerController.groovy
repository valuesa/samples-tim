package cn.boxfish.restful.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by LuoLiBing on 15/10/15.
 */
@RequestMapping(value = "/mobile/hospital")
@Controller
class CustomerController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String index() {
        return "success";
    }
}
