package pattern.factory.method;

import pattern.factory.entity.Animal;

/**
 * @author jjj
 * @date 2020/5/21 22:46
 */

/**
 * 工厂方法模式
 * 与简单工厂模式不同的是
 * 工厂模式将对象实例的过程下沉到工厂接口的实现类中
 * 实例由其对应的工厂创建
 */

/**
 * 优点：遵循开闭原则（对拓展开放，对修改关闭）
 * 单一职责 一个工厂对应一种对象
 * 对用户隐藏创建细节
 *
 * 缺点：每新增一种对象都需要新增与之对应的工厂类
 * 只支持一种类型的对象创建 如Animal
 */
public interface AnimalFactory {

    public Animal createAnimal();
}
