package cn.boxfish.retry.service;

import java.util.ArrayList;

/**
 * Created by LuoLiBing on 16/4/26.
 */
public class Test<K, V, T, M> {

    public K get(K k) {
        return k;
    }

    public <N> N getN(N n) {
        return n;
    }

    public static void main(String[] args) {
        final Object n = new Test<>().getN(new Object());
        final Class<ArrayList> clazz = new Test<>().getN(ArrayList.class);

        final ArrayList arrayList = new Test<ArrayList, Object, Object, Object>().get(new ArrayList());
        System.out.println(arrayList);
    }
}
