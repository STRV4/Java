import java.util.Locale;
import java.util.Scanner;

// Lab2 - A1 si A2
public class MeniuInteractiv {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        afiseazaBon(citesteComanda(sc));
    }

    public static void afiseazaMeniu() {
        System.out.println("---MENIU---");
        System.out.println("1. Zeama de casa - 24.50 lei");
        System.out.println("2. Piure cu parjoala - 46.00 lei");
        System.out.println("3. Salata de varza - 18.00 lei");
        System.out.println("4. Compot - 12.00 lei");
        System.out.println("0. Finalizare comanda");
        System.out.print("Alegeti: ");
    }

    public static double pretProdus(int optiune) {
        switch (optiune) {
            case 1: return 24.50;
            case 2: return 46.00;
            case 3: return 18.00;
            case 4: return 12.00;
            default: return 0;
        }
    }

    public static double aplicaReducere(double total) {
        if (total > 100) {
            return total * 0.85;
        }
        return total;
    }

    public static double citesteComanda(Scanner sc) {
        double total = 0;
        int optiune;
        do {
            afiseazaMeniu();
            optiune = sc.nextInt();
            switch (optiune) {
                case 1:
                case 2:
                case 3:
                case 4:
                    total += pretProdus(optiune);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune inexistenta");
            }
        } while (optiune != 0);
        return total;
    }

    public static void afiseazaBon(double total) {
        double dePlata = aplicaReducere(total);
        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", total - dePlata);
        System.out.printf("De plata: %.2f lei%n", dePlata);
    }
}
