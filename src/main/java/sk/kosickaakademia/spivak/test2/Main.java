package sk.kosickaakademia.spivak.test2;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = ((a, b) -> a * b);
        System.out.println(calculate.operation(4,6));
        calculate = (a, b) -> {return a>b?a:b; };
        System.out.println(calculate.operation(4,6));

        Calculate calculate1 = (a, b) -> a - b;
        print(56,43,calculate1);

        Tax taxSK = value -> 1.2*value;
        Tax taxHU = value -> 1.2*value;
        Tax taxLX = value -> 1.2*value;
        printEurWithTax(40.46, taxSK);
        printEurWithTax(40.46, taxHU);
        printEurWithTax(40.46, taxLX);
    }

    private static void print(int a, int b, Calculate calculate){
        System.out.println(calculate.operation(a,b));
    }

    private static void printEurWithTax(double value, Tax tax){
        value = tax.calcTax(value);
        value = Math.round(value*100)/100.0;
        System.out.println(value);

    }
}
