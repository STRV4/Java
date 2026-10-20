import java.util.Locale;

// Lab2 - A3
public class TabelCosturi {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        afiseazaTabelCosturi(MeniuInteractiv.pretProdus(1));
    }

    public static void afiseazaTabelCosturi(double pret) {
        System.out.println("Portii    Cost (lei)");
        for (int portii = 1; portii <= 5; portii++) {
            System.out.printf("%6d    %10.2f%n", portii, pret * portii);
        }
    }
}
