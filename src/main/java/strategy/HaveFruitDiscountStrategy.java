package strategy;

import java.math.BigDecimal;
public class HaveFruitDiscountStrategy implements FruitDiscountStrategy {
    private int num;

    public HaveFruitDiscountStrategy(int num) {
        this.num = num;
    }

    @Override
    public void setNum(int num) {
        this.num=num;
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public BigDecimal fruitPrice(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(num).divide(BigDecimal.TEN));
    }
}
