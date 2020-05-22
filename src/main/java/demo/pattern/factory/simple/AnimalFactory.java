package demo.pattern.factory.simple;

import demo.pattern.factory.entity.Animal;
import demo.pattern.factory.entity.Cat;
import demo.pattern.factory.entity.Dog;

/**
 * @author jjj
 * @date 2020/5/21 22:06
 */

/**
 * 简单工厂模式
 * 多类继承或实现同一接口
 * 给工厂类传入类型参数创建实例
 * 适用于1.创建的对象比较少
 *      2.用户不关心对象如何创建
 */

/**
 * 优点：可以对对象进行加工，隐藏创建细节
 * 缺点：1.如果创建的对象类型多，代码会臃肿
 *      2.如果新增/删除一个对象 -不符合开闭原则
 */
public class AnimalFactory {
    public static Animal createAnimal(int type){
        switch (type){
            case 1 : return new Dog();
            case 2 : return new Cat();
            default: return new Dog();
        }
    }
}
