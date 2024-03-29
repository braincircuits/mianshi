package fruit;

import strategy.FruitDiscountStrategy;
import strategy.NoFruitDiscountStrategy;

import java.math.BigDecimal;

public class Strawberry extends AbstractFruit{
    public Strawberry(BigDecimal price){
        super(price, new NoFruitDiscountStrategy());
    }
    public Strawberry(BigDecimal price, FruitDiscountStrategy fruitDiscountStrategy) {
        super(price, fruitDiscountStrategy);
    }
}
