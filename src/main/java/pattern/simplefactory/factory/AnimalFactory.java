package pattern.simplefactory.factory;

import pattern.simplefactory.entity.Animal;
import pattern.simplefactory.entity.Cat;
import pattern.simplefactory.entity.Dog;

/**
 * @author jjj
 * @date 2020/5/21 22:06
 */

/**
 * 简单工厂模式
 * 多类继承或实现同一接口
 * 给工厂类传入类型参数创建实例
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
