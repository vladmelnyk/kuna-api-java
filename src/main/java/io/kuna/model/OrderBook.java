package io.kuna.model;

import java.util.List;

public class OrderBook {
    private List<Order> asks;
    private List<Order> bids;

    public List<Order> getAsks() {
        return asks;
    }

    public void setAsks(List<Order> asks) {
        this.asks = asks;
    }

    public List<Order> getBids() {
        return bids;
    }

    public void setBids(List<Order> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "asks=" + asks +
                ", bids=" + bids +
                '}';
    }
}
