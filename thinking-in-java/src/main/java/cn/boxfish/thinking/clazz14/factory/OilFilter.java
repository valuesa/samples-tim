package cn.boxfish.thinking.clazz14.factory;

/**
 * Created by LuoLiBing on 16/9/28.
 */
public class OilFilter extends Filter {

    public static class Factory implements cn.boxfish.thinking.clazz14.factory.Factory<OilFilter> {

        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}