package io.kuna;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Map;

public class KunaClient {
    private static final String TARGET_HOST = "https://kuna.io";
    private static final String BASE_PATH = "api/v2";
    private static final String TICKER_PATH = "tickers/btcuah";
    private static final String ORDERBOOK_PATH = "order_book";
    private static final String TRADES_PATH = "trades";
    private static final Map<String, String> BTCUAH_PARAMETERS = ImmutableMap.of("market", "btcuah");
    private static Client client = ClientBuilder.newClient();

    private static String invokePublicApi(String path, Map<String, String> mapOfParameters) {
        WebTarget webTarget = client.target(TARGET_HOST).path(path);
        if (mapOfParameters != null) {
            for (Map.Entry<String, String> entry : mapOfParameters.entrySet()
                    ) {
                webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
            }
        }

        return webTarget
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    private static String invokePublicApi(String path) {
        return invokePublicApi(path, null);
    }

    public static String getTicker() {
        return invokePublicApi(BASE_PATH + "/" + TICKER_PATH);
    }

    public static String getOrderBook() {
        return invokePublicApi(BASE_PATH + "/" + ORDERBOOK_PATH, BTCUAH_PARAMETERS);
    }

    public static String getTrades() {
        return invokePublicApi(BASE_PATH + "/" + TRADES_PATH, BTCUAH_PARAMETERS);
    }

}
