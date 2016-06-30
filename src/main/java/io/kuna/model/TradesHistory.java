package io.kuna.model;

import java.util.ArrayList;

@SuppressWarnings(value = "unused")
public class TradesHistory extends ArrayList<Trade> {

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Trade trade : this
                ) {
            stringBuffer.append(trade.toString());
        }
        return "{" +
                stringBuffer.toString() + "" +
                "}";
    }
}
