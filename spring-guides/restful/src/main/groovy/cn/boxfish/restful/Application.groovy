package cn.boxfish.restful
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
/**
 * Created by LuoLiBing on 15/9/29.
 */
@SpringBootApplication
class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
