package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class CalculatorHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //localhost:8080/calc?num1=2&num2=2&type=sum

        String query = exchange.getRequestURI().getQuery();
        Map<String, String> parameters = parseQuery(query);
        OperationService operationService = new OperationService();

        Operation operation = new Operation();
        operation.setNum1(Double.parseDouble(parameters.get("num1")));
        operation.setNum2(Double.parseDouble(parameters.get("num2")));
        operation.setType(parameters.get("type"));


        Operation result = operationService.getResult(operation);

        Gson gson = new Gson();
        String json = gson.toJson(result);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, json.length());
        exchange.getResponseBody().write(json.getBytes());

        exchange.close();
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
