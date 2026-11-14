package lab3;

public class Produs {
    private static int numarProduse;

    private final int id;
    private final String denumire;
    private double pret;
    private int stoc;

    public Produs(String denumire, double pret) {
        this(denumire, pret, 0);
    }

    public Produs(String denumire, double pret, int stoc) {
        if (denumire == null || denumire.trim().isEmpty()) {
            throw new IllegalArgumentException("Denumirea produsului nu poate fi vida.");
        }
        valideazaPret(pret);
        if (stoc < 0) {
            throw new IllegalArgumentException("Stocul nu poate fi negativ.");
        }
        this.denumire = denumire.trim();
        this.pret = pret;
        this.stoc = stoc;
        this.id = ++numarProduse;
    }

    private static void valideazaPret(double pret) {
        if (!Double.isFinite(pret) || pret < 0) {
            throw new IllegalArgumentException("Pretul trebuie sa fie finit si nenegativ.");
        }
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        valideazaPret(pret);
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public boolean esteDisponibil(int cantitate) {
        return cantitate > 0 && cantitate <= getStoc();
    }

    void scadeStoc(int cantitate) {
        if (cantitate <= 0 || cantitate > stoc) {
            throw new IllegalArgumentException("Cantitate invalida pentru stocul produsului " + denumire + ".");
        }
        stoc -= cantitate;
    }

    public double pretFinal() {
        return pret;
    }

    @Override
    public String toString() {
        return String.format("#%d %s | baza: %.2f lei | final: %.2f lei | stoc: %d",
                id, denumire, getPret(), pretFinal(), getStoc());
    }

    @Override
    public boolean equals(Object obiect) {
        if (!(obiect instanceof Produs)) {
            return false;
        }
        Produs produs = (Produs) obiect;
        return id == produs.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
