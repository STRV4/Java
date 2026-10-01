import java.util.Scanner;

// B2
public class MeniuInteractiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0;
        int optiune = 1;

        while (optiune != 0) {
            System.out.println("---MENIU---");
            System.out.println("1. Zeama de casa - 24.50 lei");
            System.out.println("2. Piure cu parjoala - 46.00 lei");
            System.out.println("3. Salata de varza - 18.00 lei");
            System.out.println("4. Compot - 12.00 lei");
            System.out.println("0. Finalizare comanda");
            System.out.print("Alegeti: ");
            optiune = sc.nextInt();

            if (optiune == 1) {
                total = total + 24.50;
            } else if (optiune == 2) {
                total = total + 46.00;
            } else if (optiune == 3) {
                total = total + 18.00;
            } else if (optiune == 4) {
                total = total + 12.00;
            } else if (optiune != 0) {
                System.out.println("Optiune invalida");
            }
            System.out.printf("Total acumulat: %.2f lei%n", total);
        }

        double reducere = 0;
        if (total > 100) {
            reducere = total * 0.15;
        }
        double deplata = total - reducere;

        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("De plata: %.2f lei%n", deplata);
    }
}
