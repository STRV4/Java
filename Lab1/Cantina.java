import java.util.Scanner;

// A1
public class Cantina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----MENIUL ZILEI----");
        System.out.printf("1. %-20s %6.2f lei%n", "Zeama de casa", 24.50);
        System.out.printf("2. %-20s %6.2f lei%n", "Piure cu parjoala", 46.00);
        System.out.printf("3. %-20s %6.2f lei%n", "Salata de varza", 18.00);
        System.out.printf("4. %-20s %6.2f lei%n", "Compot", 12.00);

        System.out.print("Alegeti pozitia (1-4): ");
        int pozitia = sc.nextInt();
        System.out.print("Numar de portii: ");
        int portii = sc.nextInt();

        double pret = 0;
        if (pozitia == 1) {
            pret = 24.50;
        } else if (pozitia == 2) {
            pret = 46.00;
        } else if (pozitia == 3) {
            pret = 18.00;
        } else if (pozitia == 4) {
            pret = 12.00;
        } else {
            System.out.println("Pozitie invalida");
            return;
        }

        double total = pret * portii;
        System.out.println("Costul total: " + total + " lei");
    }
}
