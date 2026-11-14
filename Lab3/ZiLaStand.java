package lab3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;

public class ZiLaStand {
    public static final int N = 17;
    public static final int MINIM_PRODUSE = 6 + N % 3;
    public static final int REDUCERE_COMBO = 10 + N % 6;
    public static final int K = 3 + N % 4;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.printf("Waffle Atelier | N = %d | minimum %d produse | combo -%d%% | cadou la %d bonuri%n",
                N, MINIM_PRODUSE, REDUCERE_COMBO, K);

        GofraDulce vanilie = new GofraDulce("Gofra Vanilie", 20, 12, TipAluat.CLASIC, 1);
        GofraDulce cacao = new GofraDulce("Gofra Cacao", 22, 8, TipAluat.CACAO, 2);
        GofraDulcePremium premium = new GofraDulcePremium(
                "Gofra Premium Fructe", 24, 6, TipAluat.INTEGRAL, 2, 6);
        GofraSarata cascaval = new GofraSarata("Gofra Cascaval", 25, 10, TipAluat.CLASIC, true);
        GofraSarata ciuperci = new GofraSarata("Gofra Ciuperci", 24, 8, TipAluat.INTEGRAL, false);
        GofraSarata spanac = new GofraSarata("Gofra Spanac", 23, 7, TipAluat.INTEGRAL, true);
        SosArtizanal caramel = new SosArtizanal("Sos Caramel", 5, 3, 30);
        SosArtizanal fructe = new SosArtizanal("Sos Fructe", 6, 2, 50);
        Produs[] produse = {vanilie, cacao, premium, cascaval, ciuperci, spanac, caramel, fructe};
        int[] stocInitial = new int[produse.length];
        for (int i = 0; i < produse.length; i++) {
            stocInitial[i] = produse[i].getStoc();
        }

        Meniu meniuDimineata = new Meniu("Meniul diminetii");
        meniuDimineata.adaugaProdus(vanilie);
        meniuDimineata.adaugaProdus(cacao);
        Meniu meniuZiua = new Meniu("Meniul zilei");
        for (Produs produs : produse) {
            meniuZiua.adaugaProdus(produs);
        }
        meniuDimineata.afiseaza();
        meniuZiua.afiseaza();
        System.out.println("Acelasi obiect in ambele meniuri: "
                + (meniuDimineata.getProduse().get(0) == meniuZiua.getProduse().get(0)));
        vanilie.setPret(21);
        System.out.println("Dupa setPret(21), in ambele meniuri:");
        System.out.println(meniuDimineata.getProduse().get(0));
        System.out.println(meniuZiua.getProduse().get(0));
        meniuDimineata = null;
        System.out.println("meniuDimineata = null; produsul exista: " + vanilie.getDenumire());

        MeniuCombo combo = new MeniuCombo("Combo Contrast", Arrays.asList(vanilie, cascaval, caramel));
        System.out.println(combo);
        BigDecimal incasari = BigDecimal.ZERO;

        System.out.println("\nComanda 1: doua adaugari ale aceluiasi produs.");
        Comanda comanda = new Comanda();
        comanda.adauga(vanilie, 1);
        comanda.adauga(vanilie, 1);
        System.out.println("Numar linii: " + comanda.getLinii().size());
        incasari = incasari.add(emiteBon(comanda));

        System.out.println("\nComanda 2: meniu combo.");
        comanda = new Comanda();
        comanda.adauga(combo, 1);
        incasari = incasari.add(emiteBon(comanda));

        System.out.println("\nComanda 3: regula pentru sosuri este activa.");
        comanda = new Comanda();
        comanda.adauga(cacao, 1);
        comanda.adauga(ciuperci, 1);
        comanda.adauga(caramel, 2);
        incasari = incasari.add(emiteBon(comanda));

        System.out.println("\nComanda 4: un sos este refuzat din cauza stocului.");
        comanda = new Comanda();
        comanda.adauga(premium, 1);
        comanda.adauga(fructe, 2);
        comanda.adauga(fructe, 1);
        comanda.adauga(spanac, 1);
        incasari = incasari.add(emiteBon(comanda));

        System.out.println("\nComanda 5: combo refuzat, deoarece Sos Caramel s-a terminat.");
        comanda = new Comanda();
        int stocVanilie = vanilie.getStoc();
        comanda.adauga(combo, 1);
        System.out.println("Stoc Vanilie inainte/dupa refuz: " + stocVanilie + "/" + vanilie.getStoc());
        comanda.adauga(cascaval, 2);
        incasari = incasari.add(emiteBon(comanda));

        System.out.println("\n--- Inchiderea zilei ---");
        System.out.println("Numar bonuri: " + Bon.getNumarBonuri());
        System.out.println("Incasari totale: " + incasari + " lei");
        System.out.printf("%-24s %8s %12s%n", "Produs", "Vandute", "Stoc ramas");
        int maxim = 0;
        for (int i = 0; i < produse.length; i++) {
            int vandute = stocInitial[i] - produse[i].getStoc();
            System.out.printf("%-24s %8d %12d%n", produse[i].getDenumire(), vandute, produse[i].getStoc());
            maxim = Math.max(maxim, vandute);
        }
        System.out.println("Cele mai vandute produse (inclusiv in combo):");
        for (int i = 0; i < produse.length; i++) {
            if (stocInitial[i] - produse[i].getStoc() == maxim) {
                System.out.println(produse[i].getDenumire() + ": " + maxim + " buc.");
            }
        }
        experimentPrecizie();
    }

    private static BigDecimal emiteBon(Comanda comanda) {
        Bon bon = new Bon(comanda);
        bon.afiseaza();
        return bon.getTotal();
    }

    private static void experimentPrecizie() {
        double s = 0;
        BigDecimal b = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            s += 0.10;
            b = b.add(new BigDecimal("0.10"));
        }
        System.out.println("\nExperiment double / BigDecimal");
        System.out.println("double: " + s);
        System.out.println("BigDecimal: " + b);
        System.out.println("BigDecimal din double: " + new BigDecimal(0.10));
    }
}
