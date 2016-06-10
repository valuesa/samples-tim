package cn.boxfish.spring4.custom;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by LuoLiBing on 16/6/7.
 * JSR-250提供了两个注解一个是@PostConstruct和@PreDestroy注解用来实现与InitializeBean和DisposableBean
 * AutoCloseable接口能在销毁前调用close()方法,例如inputStream和outputStream等等IO
 */
@Component
public class ExampleBean1 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("autoCloseable call!!!");
    }

    public ExampleBean1() {
        System.out.println("construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("postConstruct!!!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("preDestroy!!!");
    }
}
