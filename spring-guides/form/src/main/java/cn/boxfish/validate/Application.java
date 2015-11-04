package cn.boxfish.validate;

import cn.boxfish.data.entity.Tag;
import cn.boxfish.data.entity.jpa.impl.TagJpaRepositoryImpl;
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
        TagJpaRepositoryImpl repository = ctx.getBean(TagJpaRepositoryImpl.class);
        Tag tag = repository.tag(1L);
        System.out.println(tag.getId() + ":" + tag.getName());
    }
}
