package io.kuna;

import io.kuna.model.OrderBook;
import io.kuna.model.Ticker;
import io.kuna.model.TradesHistory;

class KunaClient extends Connector {

    Integer getTimestamp() {
        return (Integer) invokePublicApi(TIMESTAMP_PATH, Integer.class);
    }

    Ticker getTicker() {
        return (Ticker) invokePublicApi(TICKER_PATH, Ticker.class);
    }

    OrderBook getOrderBook() {
        return (OrderBook) invokePublicApi(ORDERBOOK_PATH, BTCUAH_PARAMETERS, OrderBook.class);
    }

    TradesHistory getTradesHistory() {
        return (TradesHistory) invokePublicApi(TRADES_PATH, BTCUAH_PARAMETERS, TradesHistory.class);
    }

}
