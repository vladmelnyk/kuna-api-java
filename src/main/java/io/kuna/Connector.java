package io.kuna;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

class Connector {

    private static final String TARGET_HOST = "https://kuna.io";
    static final String BASE_PATH = "api/v2";
    static final String TICKER_PATH = "tickers/btcuah";
    static final String ORDERBOOK_PATH = "order_book";
    static final String TIMESTAMP_PATH = "timestamp";
    static final String TRADES_PATH = "trades";
    static final Map<String, String> BTCUAH_PARAMETERS = ImmutableMap.of("market", "btcuah");
    private static Client client = ClientBuilder.newClient();

    Object sendGetRequest(String path, Map<String, String> mapOfParameters, Class type) {
        WebTarget webTarget = client.target(TARGET_HOST).path(BASE_PATH + "/" + path);
        if (mapOfParameters != null) {
            for (Map.Entry<String, String> entry : mapOfParameters.entrySet()
                    ) {
                webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return webTarget
                .request(MediaType.APPLICATION_JSON)
                .get(type);
    }

    Object sendGetRequest(String path, Class type) {
        return sendGetRequest(path, null, type);
    }

    @SuppressWarnings(value = "unchecked")
    Object sendPostRequest(String path, Map<String, String> form, Class type) {
        WebTarget webTarget = client.target(TARGET_HOST).path(BASE_PATH + "/" + path);
        MultivaluedMap<String, String> map = new MultivaluedHashMap<>();
        for (Map.Entry<String, String> entry : form.entrySet()
                ) {
            map.putSingle(entry.getKey(), entry.getValue());
        }
        return webTarget
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .post(Entity.form(map), type);
    }

}
