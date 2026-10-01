import java.util.Scanner;

// B1
public class BonFiscal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Zeama de casa - 24.50 lei");
        System.out.println("2. Piure cu parjoala - 46.00 lei");
        System.out.println("3. Salata de varza - 18.00 lei");
        System.out.println("4. Compot - 12.00 lei");

        System.out.print("Alegeti pozitia (1-4): ");
        int pozitia = sc.nextInt();
        System.out.print("Numar de portii: ");
        int portii = sc.nextInt();
        System.out.print("Student bursier? (1 = da, 0 = nu): ");
        int bursier = sc.nextInt();

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
            System.out.println("Pozitie invalida!");
            return;
        }

        double subtotal = pret * portii;

        double reducere = 0;
        if (bursier == 1) {
            reducere = subtotal * 0.15;
        }

        double dupaReducere = subtotal - reducere;
        double tva = dupaReducere * 0.20;
        double total = dupaReducere + tva;

        System.out.println("----BON FISCAL----");
        System.out.printf("Subtotal:  %.2f lei%n", subtotal);
        System.out.printf("Reducere:  %.2f lei%n", reducere);
        System.out.printf("TVA (20%%): %.2f lei%n", tva);
        System.out.printf("TOTAL:     %.2f lei%n", total);
    }
}
