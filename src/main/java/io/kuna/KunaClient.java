package io.kuna;

import io.kuna.model.OrderBook;
import io.kuna.model.Ticker;
import io.kuna.model.TradesHistory;

class KunaClient extends Connector{

    Integer getTimestamp() {
        return (Integer) invokePublicApi(Connector.BASE_PATH + "/" + Connector.TIMESTAMP_PATH, Integer.class);
    }

    Ticker getTicker() {
        return (Ticker) invokePublicApi(Connector.BASE_PATH + "/" + Connector.TICKER_PATH, Ticker.class);
    }

    OrderBook getOrderBook() {
        return (OrderBook)invokePublicApi(Connector.BASE_PATH + "/" + Connector.ORDERBOOK_PATH, Connector.BTCUAH_PARAMETERS, OrderBook.class);
    }

    TradesHistory getTradesHistory() {
        return (TradesHistory) invokePublicApi(Connector.BASE_PATH + "/" + Connector.TRADES_PATH, Connector.BTCUAH_PARAMETERS, TradesHistory.class);
    }

}
