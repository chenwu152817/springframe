package demo.pattern.factory.abstact;

import demo.pattern.factory.entity.Animal;
import demo.pattern.factory.entity.Food;

/**
 * @author jjj
 * @date 2020/5/21 23:29
 */

/**
 * 抽象工厂模式
 * 工厂方法模式的升级
 * 可以创建多种不同类型实例
 * 不遵循开闭原则
 * 如果再新增一个对象 例如宠物玩具 那么该类又需要新增一个方法public Toys createToys();
 * 那么spring如何解决这一问题--结合了工厂模式和反射机制的springIOC容器
 */
public interface PetShopFactory {
    public Animal createAnimal();
    public Food createFood();
}
