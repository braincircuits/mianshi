package strategy;

import java.math.BigDecimal;

// 无折扣策略
public class NoFruitDiscountStrategy implements FruitDiscountStrategy {
    // 1折 无折扣
    private int num=1;

    @Override
    public void setNum(int num) {
        throw new RuntimeException("无折扣不能设置");
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public BigDecimal fruitPrice(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(num));
    }
}
