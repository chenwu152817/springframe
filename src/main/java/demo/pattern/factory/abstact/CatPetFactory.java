package demo.pattern.factory.abstact;

import demo.pattern.factory.entity.Animal;
import demo.pattern.factory.entity.Cat;
import demo.pattern.factory.entity.CatFood;
import demo.pattern.factory.entity.Food;

/**
 * @author jjj
 * @date 2020/5/21 23:30
 */

public class CatPetFactory implements PetShopFactory{
    public Animal createAnimal() {
        return new Cat();
    }

    public Food createFood() {
        return new CatFood();
    }
}
