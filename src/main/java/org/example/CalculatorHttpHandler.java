package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getQuery();
        Map<String, String> params = new HashMap<>();

    }

    private Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            String[] split = pair.split("=");
            result.put(split[0], split[1]);

        }
        return result;
    }
}
