package org.springframework.core;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jjj
 * @date 2020/5/24 15:24
 */
public class BeanContainerTest {

    private static BeanContainer beanContainer;


    @Test
    public void loadBeansTest(){
        beanContainer = BeanContainer.getInstance();
        System.out.println(beanContainer.isLoaded());
        beanContainer.loadBeans("demo.pattern.factory.entity");
        System.out.println(beanContainer.size());
    }
}
