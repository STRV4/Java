import java.util.Locale;
import java.util.Scanner;

// Lab2 - B1, C1 si C2
public class Cantina {
    private static int numarBonuri = 0;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Ziua (1 = luni, ..., 7 = duminica): ");
        int ziua = sc.nextInt();
        System.out.print("Ora (0-23): ");
        int ora = sc.nextInt();

        if (!esteDeschis(ziua, ora)) {
            System.out.println("Cantina este inchisa. Nu se accepta comenzi.");
            return;
        }
        int altaComanda;
        do {
            afiseazaBon(MeniuInteractiv.citesteComanda(sc));
            System.out.print("Alta comanda? (1 = da, 0 = nu): ");
            altaComanda = sc.nextInt();
        } while (altaComanda == 1);
    }

    public static void afiseazaBon(double total) {
        numarBonuri++;
        System.out.println("---- Bon nr. " + numarBonuri + " ----");
        double dupaReducere = MeniuInteractiv.aplicaReducere(total);
        int numar = ZiuaNorocoasa.genereazaNumar(1, 10);
        double dePlata = ZiuaNorocoasa.aplicaPremiu(dupaReducere, numar);

        System.out.printf("Total: %.2f lei%n", total);
        System.out.printf("Reducere: %.2f lei%n", total - dupaReducere);
        System.out.println("Numarul norocos: " + numar);
        if (numar == 7) {
            System.out.println("Compot gratuit! Se scad 12.00 lei, fara suma negativa.");
        }
        System.out.printf("De plata: %.2f lei%n", dePlata);
    }

    public static boolean esteDeschis(int ziua, int ora) {
        return (ziua >= 1 && ziua <= 5 && ora >= 8 && ora < 16)
                || (ziua == 6 && ora >= 9 && ora < 13);
    }
}
