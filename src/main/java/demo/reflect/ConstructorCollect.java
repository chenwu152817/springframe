package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jjj
 * @date 2020/5/22 22:52
 */
public class ConstructorCollect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("demo.reflect.ReflectTarget");
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }
        Constructor[] constructors2 = clazz.getDeclaredConstructors();
        for(Constructor constructor:constructors2){
            System.out.println(constructor);
        }
        Constructor constructor = clazz.getConstructor();
        Object object = constructor.newInstance();

        Constructor constructor2 = clazz.getConstructor(String.class);
        Object object1 = constructor2.newInstance("aaa");

        Constructor constructor3 = clazz.getDeclaredConstructor(int.class);
        constructor3.setAccessible(true);
        Object object2 = constructor3.newInstance(1);
    }
}
