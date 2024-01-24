public class complexNumberDemo {
        public static void main(String[] args) {

            complexNumberExcepHand num1 = new complexNumberExcepHand(1, 2);
            complexNumberExcepHand num2 = new complexNumberExcepHand(3, 4);

            double module1 = num1.getModule();
            double argument1 = num1.getArgument();

            System.out.println("num1 = " + num1);
            System.out.println("Moduł num1: " + module1);
            System.out.println("Argument num1: " + argument1);

            complexNumberExcepHand sum = num1.add(num2);
            complexNumberExcepHand difference = num1.subtract(num2);
            complexNumberExcepHand product = num1.multiply(num2);
            complexNumberExcepHand quotient = num1.divide(num2);
            complexNumberExcepHand power = num1.power(3);

            System.out.println("Suma: " + sum.toString());
            System.out.println("Różnica: " + difference.toString());
            System.out.println("Iloczyn: " + product.toString());
            System.out.println("Iloraz: " + quotient.toString());
            System.out.println("Wynik potęgowania num^3: " + power.toString());

            complexNumberExcepHand polarNum1 = complexNumberExcepHand.fromPolar(module1, argument1);
            System.out.println("Forma katezjańska num1: " + polarNum1);

            complexNumberExcepHand num3 = new complexNumberExcepHand(1, 2);
            System.out.println("num1 equals num3: " + num1.equals(num3));
        }
}