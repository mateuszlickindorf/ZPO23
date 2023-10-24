import java.util.Scanner;

public class Ex1 {
    /**
     * Oblicza zasięg i maksymalny pułap pocisku na podstawie danych wprowadzonych przez użytkownika.
     *
     * @param args Argumenty wiersza poleceń.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj prędkość: ");
        double v0;
        try {
            v0 = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Błąd: Wprowadź poprawną wartość liczbową dla prędkości.");
            return;
        }
        System.out.println("Podaj kąt uderzenia: ");
        double angle;
        try {
            angle = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Błąd: Wprowadź poprawną wartość liczbową dla kąta.");
            return;
        }
        double angle_radian = Math.toRadians(angle);

        scanner.close();

        if (v0 < 0 || angle < 0 || angle > 90) {
            System.out.println("Nieprawidłowe dane wejściowe.");
        } else {
            double distance = (Math.pow(v0, 2) * Math.sin(2 * angle_radian)) / 9.81;
            double maxHeight = (Math.pow(v0, 2) * Math.pow(Math.sin(angle_radian), 2) / (2 * 9.81));

            System.out.println("Zasięg: " + distance + " m");
            System.out.println("Maksymalna wysokość: " + maxHeight + " m");
        }
    }
}
