package cn.boxfish.cloud.config.server;

import cn.boxfish.cloud.config.server.entity.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.env.Environment;

/**
 * Created by LuoLiBing on 17/3/2.
 * Config的Server端, 默认需要配置一个git地址
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication implements CommandLineRunner {

    @Autowired
    private Environment env;

    /**
     * 是一个环境配置库, 一般指向的是git库
     */
    @Autowired
    private EnvironmentRepository repository;

    @Autowired
    private PersonConfig personConfig;

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(repository);
        System.out.println(personConfig);
    }
}
