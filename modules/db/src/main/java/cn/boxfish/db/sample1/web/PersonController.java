package cn.boxfish.db.sample1.web;

import cn.boxfish.db.sample1.entity.Person;
import cn.boxfish.db.sample1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LuoLiBing on 17/2/21.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public Object save() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 400; i++) {
            Runnable task;
            final int finalI = i;
            if(i % 2 == 0) {
                task = () -> {
                    personService.save(new Person("luolibing", 20), 20, finalI);
                };
            } else {
                final int finalI1 = i;
                task = () -> {
                    personService.save(new Person("luolibing", 25), 25, finalI1);
                };
            }
            exec.submit(task);
        }
        exec.shutdown();
        while (!exec.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("finish");
        return ResponseEntity.ok().build();
    }
}
