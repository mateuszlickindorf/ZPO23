import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj współrzędne pierwszego punktu: ");
        double pierwszyPunktX = scanner.nextDouble();
        double pierwszyPunktY = scanner.nextDouble();
        System.out.println("Podaj współrzędne drugiego punktu: ");
        double drugiPunktX = scanner.nextDouble();
        double drugiPunktY = scanner.nextDouble();

        scanner.close();

        try {
            double[] rownanie = wspolczynniki(pierwszyPunktX, drugiPunktX, pierwszyPunktY, drugiPunktY);
            System.out.println("y = " + rownanie[0] + "x + " + rownanie[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double[] wspolczynniki(double pierwszyPunktX, double drugiPunktX, double pierwszyPunktY, double drugiPunktY) {
        if ((drugiPunktX == pierwszyPunktX) && (drugiPunktY == pierwszyPunktY)){
            throw new IllegalArgumentException("Współrzędne punktów nie mogą być takie same.");
        }
        double a = (drugiPunktY - pierwszyPunktY) / (drugiPunktX - pierwszyPunktX);
        double b = pierwszyPunktY - (a * pierwszyPunktX);
        return new double[]{a, b};
    }
}
