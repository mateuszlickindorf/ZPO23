public class complexNumberExtendedDemo {
    public static void main(String[] args) {

        complexNumberExtended num1 = new complexNumberExtended(1, 2);
        complexNumberExtended num2 = new complexNumberExtended(3, 4);

        double module1 = num1.getModule();
        double argument1 = num1.getArgument();

        System.out.println("num1 = " + num1);
        System.out.println("Moduł num1: " + module1);
        System.out.println("Argument num1: " + argument1);

        complexNumberExtended sum = num1.add(num2);
        complexNumberExtended difference = num1.subtract(num2);
        complexNumberExtended product = num1.multiply(num2);
        complexNumberExtended quotient = num1.divide(num2);
        complexNumberExtended power = num1.power(3);

        System.out.println("Suma: " + sum.toString());
        System.out.println("Różnica: " + difference.toString());
        System.out.println("Iloczyn: " + product.toString());
        System.out.println("Iloraz: " + quotient.toString());
        System.out.println("Wynik potęgowania num^3: " + power.toString());

        complexNumberExtended polarNum1 = complexNumberExtended.fromPolar(module1, argument1);
        System.out.println("Forma kartezjańska num1: " + polarNum1);

        complexNumberExtended num3 = new complexNumberExtended(1, 2);
        System.out.println("num1 equals num3: " + num1.equals(num3));
        try {
            complexNumberExtended number = complexNumberExtended.getComplexNumberFromUser();
            // Process the valid input
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
            System.out.println("Invalid input details: " + e.getInput());
            // Handle the invalid input case
        }
    }
}
