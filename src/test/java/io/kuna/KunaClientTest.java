package io.kuna;

import io.kuna.model.OrderBook;
import io.kuna.model.Ticker;
import io.kuna.model.TradesHistory;
import org.junit.Assert;
import org.junit.Test;

public class KunaClientTest {

    private KunaClient kunaClient = new KunaClient();

    @Test
    public void getTimestamp_NotNull(){
        Assert.assertNotNull(kunaClient.getTimestamp());
    }
    @Test
    public void getTicker_NotNull(){
        Assert.assertNotNull(kunaClient.getTicker());
    }
    @Test
    public void getTicker_TickerClassReturned(){
        Assert.assertEquals(Ticker.class,kunaClient.getTicker().getClass());
    }
    @Test
    public void getOrderBook_NotNull(){
        Assert.assertNotNull(kunaClient.getOrderBook());
    }
    @Test
    public void getOrderBook_OrderBookClassReturned(){
        Assert.assertEquals(OrderBook.class,kunaClient.getOrderBook().getClass());
    }
    @Test
    public void getTradesHistory_NotNull(){
        Assert.assertNotNull(kunaClient.getTradesHistory());
    }
    @Test
    public void getTradesHistory_TradesHistoryClassReturned(){
        Assert.assertEquals(TradesHistory.class,kunaClient.getTradesHistory().getClass());
    }


}
