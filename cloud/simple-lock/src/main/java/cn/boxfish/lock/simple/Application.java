package cn.boxfish.lock.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by LuoLiBing on 17/2/24.
 *
 * 分布式锁的简单实现, 使用Redis实现
 *
 * TODO
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
