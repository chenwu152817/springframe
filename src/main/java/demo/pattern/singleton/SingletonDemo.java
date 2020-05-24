package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jjj
 * @date 2020/5/24 13:37
 */
public class SingletonDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(EnumStarvingSingleton.getInstance());
        Class clazz = EnumStarvingSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton)constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
    }
}
