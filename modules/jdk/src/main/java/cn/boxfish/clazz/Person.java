package cn.boxfish.clazz;

/**
 * Created by LuoLiBing on 16/7/25.
 */
public class Person implements PersonInterface {

    public final static Integer num = 50;

    public final static String className = Student.class.getName();

    static {
        System.out.println("static init person");
    }

    {
        System.out.println("instant init person");
    }
}
