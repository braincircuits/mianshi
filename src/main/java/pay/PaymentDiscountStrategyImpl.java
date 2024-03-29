package pay;

import java.math.BigDecimal;

public class PaymentDiscountStrategyImpl implements PaymentDiscountStrategy {
    // 优惠门槛 小于0代表无优惠
    public BigDecimal threshold = new BigDecimal(-1);
    // 优惠力度
    public BigDecimal discountPrice = new BigDecimal(0);

    public PaymentDiscountStrategyImpl(BigDecimal threshold, BigDecimal discountPrice) {
        // 优惠门槛必须大于优惠力度
        if (threshold == null || discountPrice == null ||  discountPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("参数异常");
        }
        this.threshold = threshold;
        this.discountPrice = discountPrice;
    }

    @Override
    public BigDecimal price(BigDecimal bigDecimal) {
        // 如果优惠门槛小于0 说明没有优惠
        if (threshold.compareTo(BigDecimal.ZERO) < 0) {
            return bigDecimal;
        }
        // 不满足门槛
        if (threshold.compareTo(bigDecimal) > 0) {
            return bigDecimal;
        }
        // 满足门槛 传入金额减去优惠力度
        return bigDecimal.subtract(discountPrice);
    }

}
