package cn.boxfish.thinking.clazz14;

import org.junit.Test;

/**
 * Created by LuoLiBing on 16/9/27.
 */
public class CastClassTest {

    class Building {}
    class House extends Building {}

    /**
     * 可以使用Class对象的cast方法进行强转, target = class.cast(sourceObj)
     *
     */
    @Test
    public void test1() {
        Building b = new House();
        Class<House> houseType = House.class;
        // 获取子类的类型
        Class<? extends Building> aClass = houseType.asSubclass(Building.class);
        // if (obj != null && !isInstance(obj))
        House h = houseType.cast(b);
        System.out.println(h == b);
        h = (House) b;
    }
}
