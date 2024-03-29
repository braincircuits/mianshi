package fruit;

import strategy.FruitDiscountStrategy;
import strategy.NoFruitDiscountStrategy;

import java.math.BigDecimal;

public class Mango extends AbstractFruit{
    public Mango(BigDecimal price, FruitDiscountStrategy fruitDiscountStrategy) {
        super(price, fruitDiscountStrategy);
    }

    public Mango(BigDecimal price) {
        super(price,new NoFruitDiscountStrategy());
    }

}
