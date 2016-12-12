package cn.boxfish.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.TaskScheduler;

/**
 * Created by LuoLiBing on 16/11/21.
 */
//@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        String[] beans = context.getBeanDefinitionNames();
        for(String bean : beans) {
            System.out.println(bean);
        }

        System.out.println("scheduleBean=" + context.getBean(TaskScheduler.class));
    }
}
