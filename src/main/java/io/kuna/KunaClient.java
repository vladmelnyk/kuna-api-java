package io.kuna;

import io.kuna.model.*;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.*;
class KunaClient extends Connector {

    private String publicKey;
    private String secretKey;

    private String getPublicKey() {
        return publicKey;
    }

    void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    Integer getTimestamp() {
        return (Integer) sendGetRequest(TIMESTAMP_PATH, Integer.class);
    }

    Ticker getTicker() {
        return (Ticker) sendGetRequest(TICKER_PATH, Ticker.class);
    }

    OrderBook getOrderBook() {
        return (OrderBook) sendGetRequest(ORDERBOOK_PATH, BTCUAH_PARAMETERS, OrderBook.class);
    }

    TradesHistory getTradesHistory() {
        return (TradesHistory) sendGetRequest(TRADES_PATH, BTCUAH_PARAMETERS, TradesHistory.class);
    }

    TradesHistory getMyTrades() {
        return (TradesHistory) sendGetRequest("trades/my", generateSignedMapOfParameters("GET", BTCUAH_PARAMETERS, "trades/my"), TradesHistory.class);
    }

    Account getMyAccount() {
        return (Account) sendGetRequest("members/me", generateSignedMapOfParameters("GET", null, "members/me"), Account.class);
    }

    ActiveOrders getMyOrders() {
        return (ActiveOrders) sendGetRequest("orders", generateSignedMapOfParameters("GET", BTCUAH_PARAMETERS, "orders"), ActiveOrders.class);
    }

    Order sendNewOrder(String side, Double volume, Double price) {
        Map<String, String> map = new TreeMap<>();
        map.put("side", side);
        map.put("volume", String.valueOf(volume));
        map.put("price", String.valueOf(price));
        map.putAll(BTCUAH_PARAMETERS);
        return (Order) sendPostRequest("orders", generateSignedMapOfParameters("POST", map, "orders"), Order.class);
    }

    Order deleteOrder(Long id) {
        Map<String, String> map = new TreeMap<>();
        map.put("id", String.valueOf(id));
        return (Order) sendPostRequest("order/delete", generateSignedMapOfParameters("POST", map, "order/delete"), Order.class);
    }

    private Map<String, String> generateSignedMapOfParameters(String requestType, Map<String, String> mapOfParameters, String path) {
        if (publicKey != null || secretKey != null) {
            Long date = Calendar.getInstance().getTimeInMillis();
            Map<String, String> map = new TreeMap<>();
            if (mapOfParameters != null) {
                map.putAll(mapOfParameters);
            }
            map.put("access_key", getPublicKey());
            map.put("tonce", String.valueOf(date));
            map.put("signature", generateSignature(requestType, path, map));
            return map;
        } else return new HashMap<>();
    }

    private String generateSignature(String requestType, String path, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(requestType)
                .append("|/")
                .append(BASE_PATH)
                .append("/")
                .append(path)
                .append("|");
        for (Map.Entry<String, String> entry : map.entrySet()
                ) {
            stringBuilder.append(entry)
                    .append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
        return HmacUtils.hmacSha256Hex(secretKey, stringBuilder.toString());
    }

}
