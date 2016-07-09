package io.kuna.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings(value = "unused")
class Trade {

    private Integer id;
    private Double price;
    private Double volume;
    private Double funds;
    private String market;
    //convert into sql date
    @JsonProperty("created_at")
    private Object createdAt;
    private Object side;
    @JsonProperty("order_id")
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getSide() {
        return side;
    }

    public void setSide(Object side) {
        this.side = side;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", price=" + price +
                ", volume=" + volume +
                ", funds=" + funds +
                ", market='" + market + '\'' +
                ", createdAt=" + createdAt +
                ", side=" + side +
                ", orderId=" + orderId +
                '}';
    }
}
