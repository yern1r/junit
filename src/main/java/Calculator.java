public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(String a, String b) {
        int number1 = Integer.parseInt(a);
        int number2 = Integer.parseInt(b);
        return number1 + number2;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double divide(String a, String b) {
        double number1 = Integer.parseInt(a);
        double number2 = Integer.parseInt(b);
        return number1 / number2;
    }
}