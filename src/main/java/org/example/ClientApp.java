package org.example;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        String type = scanner.next();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/calc?num1=" + num1 + "&num2=" + num2 + "&type=" + type))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

//        Operation operation = new Operation();
//        Class<? extends Operation> aClass = operation.getClass();
//
//        Class<Operation> classOfT = Operation.class;
//        classOfT.getDeclaredFields()[0].setAccessible(true);
//        classOfT.getDeclaredFields()[0].set();

//        Class<Operation> operationClass = Operation.class;
//        Operation operation = operationClass.newInstance();
//        Constructor<?> declaredConstructor = operationClass.getDeclaredConstructors()[0];
//        Operation operation = (Operation) declaredConstructor.newInstance(2.2);


        Operation o = new Gson().fromJson(json, Operation.class);

        System.out.println(o);
    }
}
