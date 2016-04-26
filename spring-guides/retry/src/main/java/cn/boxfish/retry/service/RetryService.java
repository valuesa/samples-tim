package cn.boxfish.retry.service;

import cn.boxfish.retry.exception.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by LuoLiBing on 16/4/25.
 */
@Service
public class RetryService {

    /**
     * 重试机制, 抛出指定异常进行重试,最大重试次数为maxAttempts, backoff重试间隔刚开始为delay,最大间隔为maxDelay
     * @throws RemoteAccessException
     */
    @Retryable(value = { RemoteAccessException.class }, maxAttempts = 10, backoff=@Backoff(delay = 100, maxDelay = 1000))
    public void call1() throws RemoteAccessException {
        int random = new Random().nextInt(10);
        if(random < 9) {
            throw new RemoteAccessException("网络异常,需要重试");
        }
        System.out.println("正常执行方法!!!!");
    }

    /**
     * 重试之后还没成功报出错误
     * @param e
     */
    @Recover
    public void recover(RemoteAccessException e) {
        e.printStackTrace();
    }
}