package cn.boxfish.jquery;

import cn.boxfish.jquery.entity.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoLiBing on 15/10/29.
 * jquery 整合 spring boot
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting getGreeting() {
        return new Greeting(1, "luolibing", "cool");
    }
}
