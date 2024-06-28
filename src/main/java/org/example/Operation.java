package org.example;

public class Operation {
    private double num1;
    private double num2;
    private double result;
    private String type;

    public double getNum1(int i) {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2(int i) {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult(int i) {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getType(String sum) {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type='" + type + '\'' +
                '}';
    }
}
