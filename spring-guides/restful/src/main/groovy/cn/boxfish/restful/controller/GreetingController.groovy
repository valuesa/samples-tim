package cn.boxfish.restful.controller

import cn.boxfish.restful.entity.Greeting
import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

/**
 * Created by LuoLiBing on 15/9/29.
 */
@RestController
@Slf4j
class GreetingController {


    private static final String template = "hello, %s!"
    private final static AtomicLong counter = new AtomicLong()


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        int i = 1/0;
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/check/{email:.+}")
    public Object check(@PathVariable String email) {
        log.info email
        if(email.contains("qq.com")){
            return ["status": 'Y']
        }
        return ["status": 'N']
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
    public Object exceptionHandle(Exception e) {
        Map resultMap = new HashMap()
        resultMap.put("message", e.getMessage())
        return resultMap
    }

    /**
     * 也可以自行配置对应的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object runtimeExceptionHandle(Exception e) {
        Map resultMap = new HashMap()
        resultMap.put("message", e.getMessage())
        return resultMap
    }

}
