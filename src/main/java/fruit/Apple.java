package fruit;

import strategy.FruitDiscountStrategy;
import strategy.NoFruitDiscountStrategy;

import java.math.BigDecimal;

public class Apple extends AbstractFruit {
    public Apple(BigDecimal price) {
        // 默认没有折扣
        super(price,new NoFruitDiscountStrategy());
    }
    public Apple(BigDecimal price, FruitDiscountStrategy fruitDiscountStrategy){
        super(price, fruitDiscountStrategy);
    }

}
