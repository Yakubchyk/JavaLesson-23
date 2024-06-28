package org.example;


import com.google.gson.Gson;

public class ClientApp {
    public static void main(String[] args) {

        Operation operation = new Operation();
        operation.setNum1(2);
        operation.setNum2(3);
        operation.setType("sum");
        operation.setResult(5);

        Gson gson = new Gson();
        String json = gson.toJson(operation);

    }
}
