package cn.boxfish.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by LuoLiBing on 15/10/8.
 */
@SpringBootApplication
@ComponentScan(value = "cn.boxfish")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        for(String beanName: beanNames) {
            System.out.println(beanName);
        }
    }
}
