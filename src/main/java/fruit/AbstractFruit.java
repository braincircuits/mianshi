package fruit;

import strategy.FruitDiscountStrategy;
import util.AssertUtil;

import java.math.BigDecimal;

public abstract class AbstractFruit implements Fruit {
    // 优惠策略
    private FruitDiscountStrategy fruitDiscountStrategy;
    // 水果价格
    private BigDecimal price;

    public AbstractFruit(BigDecimal price, FruitDiscountStrategy fruitDiscountStrategy) {
        this.price = price;
        this.fruitDiscountStrategy = fruitDiscountStrategy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        AssertUtil.isTrue(price == null || price.compareTo(BigDecimal.ZERO) < 0, "价格不能为null且价格不能小于0");
        this.price = price;
    }

    public void setDiscount(FruitDiscountStrategy fruitDiscountStrategy) {
        AssertUtil.isTrue(fruitDiscountStrategy == null, "折扣策略不能为空");
        this.fruitDiscountStrategy = fruitDiscountStrategy;
    }

    public FruitDiscountStrategy getDiscount() {
        return fruitDiscountStrategy;
    }

    // 获取水果优惠后的价格
    public BigDecimal fruitPrice() {
        return fruitDiscountStrategy.fruitPrice(price);
    }

}
