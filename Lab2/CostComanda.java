import java.util.Locale;

// Lab2 - B2
public class CostComanda {
    public static final double TVA = 0.20;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Produs p = new Produs("Piure cu parjoala", 46.00, 15);

        System.out.printf("Cu TVA: %.2f lei%n", calculeazaCost(46.00, 2));
        System.out.printf("Bursier: %.2f lei%n", calculeazaCost(46.00, 2, true));
        System.out.printf("Produs: %.2f lei%n", calculeazaCost(p, 2));
        // Valoarea int 46 este convertita automat la double.
        System.out.printf("Pret int: %.2f lei%n", calculeazaCost(46, 2));
    }

    public static double calculeazaCost(double pret, int portii) {
        return pret * portii * (1 + TVA);
    }

    public static double calculeazaCost(double pret, int portii, boolean bursier) {
        double subtotal = pret * portii;
        if (bursier) {
            subtotal *= 0.85;
        }
        return subtotal * (1 + TVA);
    }

    public static double calculeazaCost(Produs p, int portii) {
        return calculeazaCost(p.getPret(), portii);
    }
}
