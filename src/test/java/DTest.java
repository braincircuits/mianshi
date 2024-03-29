import fruit.Apple;
import fruit.Mango;
import fruit.Strawberry;
import org.junit.jupiter.api.Test;
import pay.Order;
import pay.PaymentDiscountStrategy;
import pay.PaymentDiscountStrategyImpl;
import pay.PaymentHandler;
import strategy.HaveFruitDiscountStrategy;

import java.math.BigDecimal;

public class DTest {
    // 使用策略模式，因为继承不灵活，组合的方式更加灵活

    // 题目1
    //有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
    //现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
    //请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
    @Test
    public void test1() {
        // 3斤苹果
        double appleNum = 3;
        // 10斤香蕉
        double strawberryNum = 10;
        Order appleOrder = new Order(new BigDecimal(appleNum), new Apple(new BigDecimal(8)));

        Order strawberryOrder = new Order(new BigDecimal(strawberryNum), new Strawberry(new BigDecimal(13)));
        // 支付处理程序
        PaymentHandler paymentHandler = new PaymentHandler();

        BigDecimal bigDecimal = paymentHandler.countFruits(appleOrder, strawberryOrder);
        System.out.println(bigDecimal);
    }

    //超市增加了一种水果芒果，其定价为 20 元/斤。
    //现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
    //请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

    @Test
    public void test2() {
        // 3斤苹果
        double appleNum = 3;
        // 10斤草莓
        double strawberryNum = 10;
        // 28 斤芒果
        double mangoNum = 28;

        // 8元一斤的苹果
        Apple apple = new Apple(new BigDecimal(8));
        // 13元一斤的草莓
        Strawberry strawberry = new Strawberry(new BigDecimal(13));
        Mango mango = new Mango(new BigDecimal(20));

        Order appleOrder = new Order(new BigDecimal(appleNum), apple);
        Order strawberryOrder = new Order(new BigDecimal(strawberryNum), strawberry);
        Order order = new Order(new BigDecimal(mangoNum), mango);

        // 支付处理程序
        PaymentHandler paymentHandler = new PaymentHandler();

        BigDecimal bigDecimal = paymentHandler.countFruits(appleOrder, strawberryOrder, order);
        System.out.println(bigDecimal);

    }

    //3、超市做促销活动，草莓限时打 8 折。
    //现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
    //请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

    @Test
    public void test3(){
        // 3斤苹果
        double appleNum = 3;
        // 10斤草莓
        double strawberryNum = 10;
        // 28 斤芒果
        double mangoNum = 28;

        // 8优惠策略
        HaveFruitDiscountStrategy discountStrategy = new HaveFruitDiscountStrategy(8);

        // 8元一斤的苹果
        Apple apple = new Apple(new BigDecimal(8));
        // 13元一斤的草莓
        Strawberry strawberry = new Strawberry(new BigDecimal(13));
        // 设置草莓优惠策略
        strawberry.setDiscount(discountStrategy);



        Mango mango = new Mango(new BigDecimal(20));

        Order appleOrder = new Order(new BigDecimal(appleNum), apple);
        Order strawberryOrder = new Order(new BigDecimal(strawberryNum), strawberry);
        Order order = new Order(new BigDecimal(mangoNum), mango);

        // 支付处理程序
        PaymentHandler paymentHandler = new PaymentHandler();

        BigDecimal bigDecimal = paymentHandler.countFruits(appleOrder, strawberryOrder, order);
        System.out.println(bigDecimal);
    }

    //4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
    //现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
    //请编写函数，对于 D 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。

    @Test
    public void test4(){
        // 3斤苹果
        double appleNum = 3;
        // 10斤草莓
        double strawberryNum = 10;
        // 28 斤芒果
        double mangoNum = 28;

        // 水果8优惠策略
        HaveFruitDiscountStrategy discountStrategy = new HaveFruitDiscountStrategy(8);

        // 支付优惠策略 满100减10
        PaymentDiscountStrategy paymentDiscountStrategy = new PaymentDiscountStrategyImpl(new BigDecimal(100), new BigDecimal(10));

        // 8元一斤的苹果
        Apple apple = new Apple(new BigDecimal(8));
        // 13元一斤的草莓 8优惠策略
        Strawberry strawberry = new Strawberry(new BigDecimal(13),discountStrategy);

        Mango mango = new Mango(new BigDecimal(20));

        Order appleOrder = new Order(new BigDecimal(appleNum), apple);
        Order strawberryOrder = new Order(new BigDecimal(strawberryNum), strawberry);
        Order order = new Order(new BigDecimal(mangoNum), mango);

        // 支付处理程序
        PaymentHandler paymentHandler = new PaymentHandler();
        // 设置支付优惠策略
        paymentHandler.setPaymentDiscountStrategy(paymentDiscountStrategy);

        BigDecimal bigDecimal = paymentHandler.countFruits(appleOrder, strawberryOrder, order);
        System.out.println(bigDecimal);

    }

}
