package cn.boxfish.demo2;

import cn.boxfish.demo1.consumer.*;
import cn.boxfish.demo1.producer.MyProducer;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by LuoLiBing on 15/10/24.
 */
public class Runner {


    public void run() throws IOException, TimeoutException, InterruptedException {
        // 消费者1
        cn.boxfish.demo2.MyConsumer consumer1 = new cn.boxfish.demo2.MyConsumer("queue1");
        Thread consumerThread1 = new Thread(consumer1);
        consumerThread1.start();

        // 消费者2
        cn.boxfish.demo2.MyConsumer consumer2 = new cn.boxfish.demo2.MyConsumer("queue2");
        Thread consumerThread2 = new Thread(consumer2);
        consumerThread2.start();

        // 生产者
        MyProducer producer = new MyProducer("queue1");

        for(int i = 0; i<10000; i++) {
            Map<String, String> message = new HashMap<>();
            message.put("message number", "message " + i);
            producer.sendMessage((Serializable) message);
            Thread.sleep(100);
        }
    }
}
