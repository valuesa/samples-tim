package cn.boxfish.restful
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.ShallowEtagHeaderFilter

import javax.servlet.Filter

/**
 * Created by LuoLiBing on 15/9/29.
 */
@SpringBootApplication
@Slf4j
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
}
