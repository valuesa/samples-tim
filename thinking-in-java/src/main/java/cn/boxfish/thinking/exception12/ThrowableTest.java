package cn.boxfish.thinking.exception12;

import org.junit.Test;

/**
 * Created by LuoLiBing on 16/9/23.
 *
 * Throwable这个类被用来表示任何可以作为异常被抛出的类
 * Throwable分位两种类型: Error和Exception
 * Error用来表示编译时和系统错误(常见的有AssertionError断言错); Exception是可以被抛出的基本类型
 *
 * 运行时异常,有很多运行时异常java会自动抛出,例如NullPointerException等.运行时异常不需要再方法声明中定义出来,也可以定义出来,但是并不会强制使用try Catch
 * RuntimeException,不受检查异常,这种异常属于错误,将会被自动捕获. 不捕获运行时异常,该异常能直达Main函数,输出报告给System.error,退出前调用printStackTrace
 * 只能在代码中忽略RuntimeException及其子类的异常,其他类型异常处理由编译器强制实施.究其原因,RuntimeException代表的是编程错误
 */
public class ThrowableTest {

    public void f1() {
        throw new RuntimeException("错误");
    }

    @Test
    public void test1() {
        f1();
    }

    public static void main(String[] args) {
        new ThrowableTest().test1();
    }
}
