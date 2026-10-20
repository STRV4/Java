import java.util.Locale;
import java.util.Scanner;

// Lab2 - B3
public class ComandaLimitata {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double total = 0;

        // Se numara doar pozitiile valide, maximum 5.
        for (int pozitii = 0; pozitii < 5;) {
            MeniuInteractiv.afiseazaMeniu();
            int optiune = sc.nextInt();
            if (optiune == 0) {
                break;
            }
            if (optiune < 1 || optiune > 4) {
                System.out.println("Optiune inexistenta");
                continue;
            }
            total += MeniuInteractiv.pretProdus(optiune);
            pozitii++;
        }
        System.out.printf("Total: %.2f lei%n", total);
    }
}
