import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj kod HEX: ");
        String k = scanner.nextLine();

        scanner.close();

        if (k.length() != 6) {
            System.out.println("Kod HEX został źle podany, musi składać się z 6 znaków.") ;
            return;
        }
        String s1 = k.substring(0, 2);
        String s2 = k.substring(2, 4);
        String s3 = k.substring(4, 6);

        int r = Integer.parseInt(s1, 16);
        int g = Integer.parseInt(s2, 16);
        int b = Integer.parseInt(s3, 16);
        System.out.printf("(" + r + "," + g + "," + b + ")");

    }
}
