package io.kuna.model;

import com.fasterxml.jackson.annotation.JsonProperty;

class Order {
    private Long id;
    private String side;
    @JsonProperty("ord_type")
    private String orderType;
    private Double price;
    @JsonProperty("avg_price")
    private Double averagePrice;
    private String state;
    private String market;
    @JsonProperty("created_at")
    private String createdAt;
    private Double volume;
    @JsonProperty("remaining_volume")
    private Double remainingVolume;
    @JsonProperty("executed_volume")
    private Double executedVolume;
    @JsonProperty("trades_count")
    private Integer tradesCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getRemainingVolume() {
        return remainingVolume;
    }

    public void setRemainingVolume(Double remainingVolume) {
        this.remainingVolume = remainingVolume;
    }

    public Double getExecutedVolume() {
        return executedVolume;
    }

    public void setExecutedVolume(Double executedVolume) {
        this.executedVolume = executedVolume;
    }

    public Integer getTradesCount() {
        return tradesCount;
    }

    public void setTradesCount(Integer tradesCount) {
        this.tradesCount = tradesCount;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", orderType='" + orderType + '\'' +
                ", price=" + price +
                ", averagePrice=" + averagePrice +
                ", state='" + state + '\'' +
                ", market='" + market + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", remainingVolume=" + remainingVolume +
                ", executedVolume=" + executedVolume +
                ", tradesCount=" + tradesCount +
                '}';
    }
}
