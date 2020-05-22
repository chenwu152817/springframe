package demo.pattern.factory.method;

import demo.pattern.factory.entity.Animal;
import demo.pattern.factory.entity.Cat;

/**
 * @author jjj
 * @date 2020/5/21 22:47
 */
public class CatFactory implements AnimalFactory{
    public Animal createAnimal() {
        return new Cat();
    }
}
