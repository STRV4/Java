package lab3;

import java.util.ArrayList;

public class Meniu {
    private String denumire;
    private ArrayList<Produs> produse = new ArrayList<>();

    public Meniu(String denumire) {
        this.denumire = denumire;
    }

    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    public ArrayList<Produs> getProduse() {
        return produse;
    }

    public void afiseaza() {
        System.out.println("\n" + denumire);
        for (Produs produs : produse) {
            System.out.println(produs);
        }
    }
}
