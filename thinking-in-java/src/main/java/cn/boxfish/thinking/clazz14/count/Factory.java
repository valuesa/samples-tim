package cn.boxfish.thinking.clazz14.count;

/**
 * Created by LuoLiBing on 16/9/28.
 */
public interface Factory<Pet> {
    Pet create(int index);
}
