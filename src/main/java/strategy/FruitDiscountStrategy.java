package strategy;

import java.math.BigDecimal;

// 水果优惠接口
public interface FruitDiscountStrategy {

    void setNum(int num);

    int getNum();


    /**
     * 传入原价，计算打折后的金额
     * @param originalPrice 原价
     * @return 返回打折后的金额
     */
    BigDecimal fruitPrice(BigDecimal originalPrice);
}
