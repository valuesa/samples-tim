package cn.boxfish.mail;

import cn.boxfish.mail.entity.Teacher;
import cn.boxfish.mail.entity.WorkOrder;
import cn.boxfish.mail.service.Test1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by LuoLiBing on 16/2/29.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Test1Service test1Service;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CriteriaBuilder criteriaBuilder(EntityManager entityManager) {
        return entityManager.getCriteriaBuilder();
    }

    @Override
    public void run(String... strings) throws Exception {
        final List<Teacher> teachers = test1Service.findTeacher();
        List<Teacher> list = test1Service.findByNameNotNull();
        List<WorkOrder> list2 = test1Service.findByStatusNotNull();
        System.out.println(list2);
        System.out.println(list);
        System.out.println(teachers);
    }
}
