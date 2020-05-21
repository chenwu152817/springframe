package pattern.factory.abstact;

import pattern.factory.entity.Animal;
import pattern.factory.entity.Cat;
import pattern.factory.entity.CatFood;
import pattern.factory.entity.Food;

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
