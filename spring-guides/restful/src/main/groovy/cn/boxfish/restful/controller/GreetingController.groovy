package cn.boxfish.restful.controller

import cn.boxfish.restful.entity.Greeting
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

/**
 * Created by LuoLiBing on 15/9/29.
 */
@RestController
class GreetingController {


    private static final String template = "hello, %s!"
    private final static AtomicLong counter = new AtomicLong()


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/genericException", method = RequestMethod.GET)
    public Greeting genericException(@RequestParam(value = "name", defaultValue = "world") String name) {
        def greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name))
        greeting.genericException()
        return greeting;
    }


    @RequestMapping(value = "/runtimeException", method = RequestMethod.GET)
    public Greeting runtimeException(@RequestParam(value = "name", defaultValue = "world") String name) {
        def greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name))
        greeting.runtimeException()
        return greeting;
    }

    /**
     * 默认情况下所有异常都由这里处理，所有的Exception子类
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandle(Exception e) {
        return e.getMessage()
    }

    /**
     * 也可以自行配置对应的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String runtimeExceptionHandle(Exception e) {
        return e.getMessage()
    }



    /**
     * Created by LuoLiBing on 15/9/23.
     * 所有controller异常处理
     */
    /*@ControllerAdvice
    public class ExceptionHandlerControllerAdvice {

        *//**
         * 捕获的异常，默认情况下都是ajax请求
         * @param e
         * @return
         *//*
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody Map<String, Object> allCatchException(Exception e) {
            e.printStackTrace();
            Map<String, Object> result = Maps.newHashMap();
            result.put("success", "N");
            result.put("message", e.getMessage());
            return result;
        }

    }*/

}
