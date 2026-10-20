import java.util.Locale;

// Lab2 - C2
public class ZiuaNorocoasa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int minim = 10;
        int maxim = 1;
        int aparitii = 0;

        for (int i = 0; i < 1000; i++) {
            int numar = genereazaNumar(1, 10);
            minim = Math.min(minim, numar);
            maxim = Math.max(maxim, numar);
            if (numar == 7) {
                aparitii++;
            }
        }
        System.out.println("Minim: " + minim);
        System.out.println("Maxim: " + maxim);
        System.out.println("Aparitii ale numarului 7: " + aparitii);
    }

    public static int genereazaNumar(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static double aplicaPremiu(double suma, int numar) {
        if (numar == 7) {
            suma -= 12.00;
        }
        suma = Math.max(0, suma);
        return Math.round(suma * 100) / 100.0;
    }
}
