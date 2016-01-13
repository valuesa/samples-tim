package cn.boxfish.restful.controller

import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletRequest
/**
 * Created by LuoLiBing on 15/10/15.
 */
@RestController
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

    @RequestMapping(value = "/get/{username:*+}", method = RequestMethod.GET)
    public String get(@PathVariable String username) {
        username
    }
}
