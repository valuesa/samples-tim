package cn.boxfish.cloud.client;

import cn.boxfish.cloud.client.person.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by LuoLiBing on 17/3/2.
 */
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private PersonConfig personConfig;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(personConfig);
    }
}
