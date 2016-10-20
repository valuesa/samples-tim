package cn.boxfish.thinking.clazz14.factory;

/**
 * Created by LuoLiBing on 16/9/28.
 */
public class FanBelt extends Belt {

    public static class Factory implements cn.boxfish.thinking.clazz14.factory.Factory<FanBelt> {

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
