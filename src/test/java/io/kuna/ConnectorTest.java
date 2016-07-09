package io.kuna;

import io.kuna.model.TradesHistory;
import org.junit.Test;
import org.mockito.Mockito;
import javax.ws.rs.BadRequestException;

public class ConnectorTest {

    private Connector connector = new Connector();

    @Test(expected=NullPointerException.class)
    public void invokePublicApiTest_WithNoPath(){
        connector.sendGetRequest(null, Mockito.any().getClass());
    }
    @Test(expected=IllegalArgumentException.class)
    public void invokePublicApiTest_WithNoClass(){
        connector.sendGetRequest(Connector.ORDERBOOK_PATH, null);
    }
    @Test(expected = BadRequestException.class)
    public void invokePublicApiTest_WithoutMapOfParameters(){
        connector.sendGetRequest(Connector.TRADES_PATH, null, TradesHistory.class);
    }

}
