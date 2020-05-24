package org.springframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Component;
import org.springframework.core.annotation.Controller;
import org.springframework.core.annotation.Repository;
import org.springframework.core.annotation.Service;
import org.springframework.util.ClassUtil;
import org.springframework.util.VaildationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jjj
 * @date 2020/5/24 14:55
 */

/**容器的组成部分
 * 1.保存Class对象及其实例的载体
 * 2.容器的加载
 * 3.容器的操作方式
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 用于存放所有被配置标记的目标对象
     */
    private final Map<Class<?>,Object> beanMap = new ConcurrentHashMap<Class<?>, Object>();

    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder{
        HOLDER;
        private BeanContainer instance;
        ContainerHolder(){
            instance = new BeanContainer();
        }
    }

    /**
     * 获取bean数量
     * @return
     */
    public int size(){
        return beanMap.size();
    }

    /**
     * 是否加载过容器
     */
    private boolean loaded = false;

    public boolean isLoaded(){
        return loaded;
    }


    /**
     * 扫描所有的Bean
     */
    public synchronized void loadBeans(String packageName){
        if (isLoaded()){
            log.warn("beanContainer has been loaded");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if(VaildationUtil.isEmpty(classSet)){
            log.warn("extract nothing from packageName" + packageName);
            return;
        }
        for(Class<?> clazz : classSet){
            for(Class<? extends Annotation> annotion:BEAN_ANNOTATION){
                if(clazz.isAnnotationPresent(annotion)){
                    beanMap.put(clazz,ClassUtil.newInstance(clazz,true));
                }
            }
        }
        loaded = true;
    }
}
