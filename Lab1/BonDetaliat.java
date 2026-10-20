import java.util.Scanner;

// C2
public class BonDetaliat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int zeama = 0;
        int piure = 0;
        int salata = 0;
        int compot = 0;
        int optiune = -1;

        while (optiune != 0) {
            System.out.println("--- MENIU ---");
            System.out.println("1. Zeama de casa - 24.50 lei");
            System.out.println("2. Piure cu parjoala - 46.00 lei");
            System.out.println("3. Salata de varza - 18.00 lei");
            System.out.println("4. Compot - 12.00 lei");
            System.out.println("0. Finalizare comanda");
            System.out.print("Alegeti: ");
            optiune = sc.nextInt();

            if (optiune == 1) {
                zeama++;
            } else if (optiune == 2) {
                piure++;
            } else if (optiune == 3) {
                salata++;
            } else if (optiune == 4) {
                compot++;
            } else if (optiune != 0) {
                System.out.println("Optiune invalida!");
            }
        }

        double subZeama = zeama * 24.50;
        double subPiure = piure * 46.00;
        double subSalata = salata * 18.00;
        double subCompot = compot * 12.00;
        double total = subZeama + subPiure + subSalata + subCompot;

        System.out.println("---- BON DETALIAT ----");
        if (zeama > 0) {
            System.out.printf("Zeama de casa x %d = %.2f%n", zeama, subZeama);
        }
        if (piure > 0) {
            System.out.printf("Piure cu parjoala x %d = %.2f%n", piure, subPiure);
        }
        if (salata > 0) {
            System.out.printf("Salata de varza x %d = %.2f%n", salata, subSalata);
        }
        if (compot > 0) {
            System.out.printf("Compot x %d = %.2f%n", compot, subCompot);
        }

        double reducere = 0;
        if (total > 100) {
            reducere = total * 0.15;
        }
        System.out.printf("Reducere: %.2f%n", reducere);
        System.out.printf("TOTAL: %.2f lei%n", total - reducere);
    }
}
