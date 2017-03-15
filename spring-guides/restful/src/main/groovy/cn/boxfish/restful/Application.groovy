package cn.boxfish.restful
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.filter.ShallowEtagHeaderFilter

import javax.servlet.Filter

/**
 * Created by LuoLiBing on 15/9/29.
 */
@SpringBootApplication
@Slf4j
@Controller
class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        println "aaaaaaaaaaaaaa"
        SpringApplication.run(Application.class, args)
        log.info "测试日志11111"
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index"
    }
}
