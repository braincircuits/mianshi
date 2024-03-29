package pay;

import util.AssertUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PaymentHandler {
    public PaymentDiscountStrategy getPaymentDiscountStrategy() {
        return paymentDiscountStrategy;
    }

    public void setPaymentDiscountStrategy(PaymentDiscountStrategy paymentDiscountStrategy) {
        this.paymentDiscountStrategy = paymentDiscountStrategy;
    }

    // 计算支付金额的策略,默认没有优惠
    private PaymentDiscountStrategy paymentDiscountStrategy = new PaymentDiscountStrategyImpl(BigDecimal.valueOf(-1), BigDecimal.ZERO);

    public PaymentHandler() {

    }

    public PaymentHandler(PaymentDiscountStrategy paymentDiscountStrategy) {
        this.paymentDiscountStrategy = paymentDiscountStrategy;
    }

    public BigDecimal countFruits(Order... orders) {
        AssertUtil.isTrue(orders == null || orders.length == 0,"商品不能为空");

        BigDecimal bigDecimal = Arrays.stream(orders).map(e -> e.getNum().multiply(e.getFruit().fruitPrice())).reduce(BigDecimal::add).get();

        // 四舍五入
        return paymentDiscountStrategy.price(bigDecimal).setScale(2, RoundingMode.HALF_UP);
    }
}
