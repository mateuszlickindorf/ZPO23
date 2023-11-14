public class complexNumberDemo {
    public static void main(String[] args) {

        complexNumber num1 = new complexNumber(1, 2);
        complexNumber num2 = new complexNumber(3, 4);

        double module1 = num1.getModule();
        double argument1 = num1.getArgument();

        System.out.println("num1 = " + num1);
        System.out.println("Moduł num1: " + module1);
        System.out.println("Argument num1: " + argument1);

        complexNumber sum = num1.add(num2);
        complexNumber difference = num1.subtract(num2);
        complexNumber product = num1.multiply(num2);
        complexNumber quotient = num1.divide(num2);
        complexNumber power = num1.power(3);

        System.out.println("Suma: " + sum.toString());
        System.out.println("Różnica: " + difference.toString());
        System.out.println("Iloczyn: " + product.toString());
        System.out.println("Iloraz: " + quotient.toString());
        System.out.println("Wynik potęgowania num^3: " + power.toString());

        complexNumber polarNum1 = complexNumber.fromPolar(module1, argument1);
        System.out.println("Forma kartezjańska num1: " + polarNum1);

        complexNumber num3 = new complexNumber(1, 2);
        System.out.println("num1 equals num3: " + num1.equals(num3));
    }
}
