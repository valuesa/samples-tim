package cn.boxfish.resttemplate

import cn.boxfish.resttemplate.entity.Value
import cn.boxfish.resttemplate.exception.MyCustomException
import groovy.util.logging.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.client.RestTemplate

/**
 * Created by LuoLiBing on 15/9/30.
 */
@SpringBootApplication
@Slf4j
class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }


    /**
     * httpClient
     * @param args
     * @throws Exception
     */
    @Override
    void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate()
        // 异常处理
        restTemplate.setErrorHandler(new MyCustomException())
        try {
            def value = restTemplate.getForObject(
                    "http://localhost:8080/genericException?name=luolibing", Value.class)
            log.info("id:$value.id,name:$value.content")
        } catch (Exception e) {
            println e.cause
        }

    }
}
