import java.util.Locale;

// Lab2 - C3
public class TestParametri {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        double pret = 24.50;
        Produs p = new Produs("Zeama de casa", 24.50, 20);

        System.out.printf("Variabila inainte: %.2f lei%n", pret);
        majoreazaPret(pret);
        System.out.printf("Variabila dupa: %.2f lei%n", pret);

        System.out.printf("Produs inainte: %.2f lei%n", p.getPret());
        majoreazaPret(p);
        System.out.printf("Produs dupa: %.2f lei%n", p.getPret());
    }

    public static void majoreazaPret(double pret) {
        // Se modifica doar copia valorii primite.
        pret *= 1.10;
    }

    public static void majoreazaPret(Produs p) {
        // Copia referintei indica acelasi obiect, deci pretul lui se modifica.
        p.setPret(p.getPret() * 1.10);
    }
}
