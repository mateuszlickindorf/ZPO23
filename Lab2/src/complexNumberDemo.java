public class complexNumberDemo {
        public static void main(String[] args) {

            complexNumber num1 = new complexNumber(1, 2);
            complexNumber num2 = new complexNumber(3, 4);

            double module1 = num1.getModule();
            double argument1 = num1.getArgument();

            System.out.println("num1 = " + num1);
            System.out.println("Moduł num1: " + module1);
            System.out.println("Argument num1: " + argument1);

            complexNumber sum = complexNumber.add(num1, num2);
            complexNumber difference = complexNumber.subtract(num1, num2);
            complexNumber product = complexNumber.multiply(num1, num2);
            complexNumber quotient = complexNumber.divide(num1, num2);
            complexNumber power = complexNumber.power(num1, 2);

            System.out.println("Suma: " + sum.toString());
            System.out.println("Różnica: " + difference.toString());
            System.out.println("Iloczyn: " + product.toString());
            System.out.println("Iloraz: " + quotient.toString());
            System.out.println("Wynik potęgowania num^3: " + power.toString());

            complexNumber polarNum1 = complexNumber.fromPolar(module1, argument1);
            System.out.println("Forma katezjańska num1: " + polarNum1);

            complexNumber num3 = new complexNumber(1, 2);
            System.out.println("num1 równa się num3: " + num1.equals(num3));
        }
}