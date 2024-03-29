package pay;

import java.math.BigDecimal;

// 支付价格优惠处理策略
public interface PaymentDiscountStrategy {
    // 支付价格优惠处理后的金额
    BigDecimal price(BigDecimal bigDecimal);
}
