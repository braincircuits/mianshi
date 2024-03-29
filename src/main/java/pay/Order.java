package pay;

import fruit.Apple;
import fruit.Fruit;

import java.math.BigDecimal;
import java.util.HashMap;

public class Order {
    // 水果斤数
    private BigDecimal num;
    //
    private Fruit fruit;

    public Order(BigDecimal num, Fruit fruit) {

        this.num = num;
        this.fruit = fruit;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
