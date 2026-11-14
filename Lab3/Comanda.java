package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Comanda {
    private ArrayList<LinieComanda> linii = new ArrayList<>();

    public boolean adauga(Produs produs, int cantitate) {
        if (produs == null || cantitate <= 0) {
            throw new IllegalArgumentException("Produs sau cantitate invalida.");
        }
        if (!produs.esteDisponibil(cantitate)) {
            System.out.println("Refuzat: " + produs.getDenumire() + ", stoc insuficient.");
            return false;
        }
        produs.scadeStoc(cantitate);
        for (LinieComanda linie : linii) {
            if (linie.getProdus().equals(produs)) {
                linie.adaugaCantitate(cantitate);
                return true;
            }
        }
        linii.add(new LinieComanda(produs, cantitate));
        return true;
    }

    public ArrayList<LinieComanda> getLinii() {
        return linii;
    }

    public BigDecimal subtotal() {
        BigDecimal suma = BigDecimal.ZERO;
        for (LinieComanda linie : linii) {
            suma = suma.add(linie.subtotal());
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }

    // O gofra dulce si una sarata: reducere de 3 lei pentru fiecare sos separat.
    public BigDecimal reducere() {
        boolean dulce = false;
        boolean sarata = false;
        for (LinieComanda linie : linii) {
            if (linie.getProdus() instanceof GofraDulce) {
                dulce = true;
            }
            if (linie.getProdus() instanceof GofraSarata) {
                sarata = true;
            }
        }
        BigDecimal suma = BigDecimal.ZERO;
        if (dulce && sarata) {
            for (LinieComanda linie : linii) {
                if (linie.getProdus() instanceof SosArtizanal) {
                    BigDecimal reducereSos = new BigDecimal("3.00")
                            .multiply(BigDecimal.valueOf(linie.getCantitate()));
                    suma = suma.add(reducereSos.min(linie.subtotal()));
                }
            }
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal total() {
        return subtotal().subtract(reducere()).setScale(2, RoundingMode.HALF_UP);
    }
}
