package cn.boxfish.restful

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
/**
 * Created by LuoLiBing on 15/9/29.
 */
@SpringBootApplication
@Slf4j
class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
        log.info "测试日志11111"
    }
}
