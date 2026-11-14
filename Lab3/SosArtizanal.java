package lab3;

public class SosArtizanal extends Produs {
    private final int grame;

    public SosArtizanal(String denumire, double pret, int stoc, int grame) {
        super(denumire, pret, stoc);
        if (grame < 30) {
            throw new IllegalArgumentException("Portia de sos trebuie sa aiba cel putin 30 de grame.");
        }
        this.grame = grame;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + 0.10 * (grame - 30);
    }

    @Override
    public String toString() {
        return super.toString() + " [sos artizanal, " + grame + " g]";
    }
}
