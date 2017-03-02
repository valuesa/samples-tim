package cn.boxfish.cloud.config.server.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LuoLiBing on 17/3/2.
 */
@Configuration
@ConfigurationProperties(prefix = "person")
public class PersonConfig {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
