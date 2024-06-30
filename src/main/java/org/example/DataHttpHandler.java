package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class DataHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        FileReader fileReader = new FileReader("data.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        Optional<String> reduce = bufferedReader.lines().reduce(String::concat);

        if (reduce.isPresent()) {
            String xml = reduce.get();
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, xml.length());
            exchange.getResponseBody().write(xml.getBytes());
        }

        exchange.close();

    }
}
