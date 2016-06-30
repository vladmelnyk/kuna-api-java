package io.kuna.model;

import java.util.ArrayList;

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
