package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LinieComanda {
    private Produs produs;
    private int cantitate;

    LinieComanda(Produs produs, int cantitate) {
        this.produs = produs;
        this.cantitate = cantitate;
    }

    public Produs getProdus() {
        return produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    void adaugaCantitate(int cantitate) {
        this.cantitate += cantitate;
    }

    public BigDecimal subtotal() {
        return BigDecimal.valueOf(produs.pretFinal())
                .multiply(BigDecimal.valueOf(cantitate))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
