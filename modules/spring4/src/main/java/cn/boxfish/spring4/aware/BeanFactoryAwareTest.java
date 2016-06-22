package cn.boxfish.spring4.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * Created by LuoLiBing on 16/6/17.
 */
@Component
public class BeanFactoryAwareTest implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
        ApplicationListenerTest bean = beanFactory.getBean(ApplicationListenerTest.class);
        System.out.println(bean);
    }
}
