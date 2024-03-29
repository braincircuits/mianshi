package fruit;

import strategy.FruitDiscountStrategy;

import java.math.BigDecimal;

public interface Fruit {
    // 水果金额
    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    // 水果优惠策略
    FruitDiscountStrategy getDiscount();
    void setDiscount(FruitDiscountStrategy fruitDiscountStrategy);

    // 水果优惠后的价格
    BigDecimal fruitPrice();
}
