package io.kuna.model;

import java.util.ArrayList;

public class ActiveOrders extends ArrayList<Order>{
    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Order order : this
                ) {
            stringBuffer.append(order.toString());
        }
        return "{" +
                stringBuffer.toString() + "" +
                "}";
    }
}
