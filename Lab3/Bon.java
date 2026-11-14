package lab3;

import java.math.BigDecimal;

public class Bon {
    private static int numarBonuri;
    private int numar;
    private Comanda comanda;

    public Bon(Comanda comanda) {
        this.comanda = comanda;
        numar = ++numarBonuri;
    }

    public static int getNumarBonuri() {
        return numarBonuri;
    }

    public BigDecimal getTotal() {
        return comanda.total();
    }

    public boolean areCadou() {
        return numar % ZiLaStand.K == 0;
    }

    public void afiseaza() {
        System.out.println("\n--- Waffle Atelier | Bon nr. " + numar + " ---");
        for (LinieComanda linie : comanda.getLinii()) {
            Produs produs = linie.getProdus();
            System.out.printf("%s | %d x %.2f = %s lei%n", produs.getDenumire(),
                    linie.getCantitate(), produs.pretFinal(), linie.subtotal());
            if (produs instanceof MeniuCombo) {
                System.out.print("  Componente: ");
                for (Produs componenta : ((MeniuCombo) produs).getComponente()) {
                    System.out.print(componenta.getDenumire() + "; ");
                }
                System.out.println();
                BigDecimal reducere = BigDecimal.valueOf(produs.getPret())
                        .subtract(BigDecimal.valueOf(produs.pretFinal()))
                        .multiply(BigDecimal.valueOf(linie.getCantitate())).setScale(2);
                System.out.println("  Reducere combo inclusa: " + reducere + " lei");
            }
        }
        System.out.println("Subtotal: " + comanda.subtotal() + " lei");
        System.out.println("Reducere regula: " + comanda.reducere() + " lei");
        System.out.println("Total: " + getTotal() + " lei");
        if (areCadou()) {
            System.out.println("Cadou: sticker Waffle Atelier");
        }
    }
}
