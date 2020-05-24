package org.springframework.util;


import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author jjj
 * @date 2020/5/23 23:44
 */
public class ClassUtilTest {

    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("demo.pattern.factory.entity");
        System.out.println(classSet);
    }
}
