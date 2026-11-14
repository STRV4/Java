package lab3;

public class GofraDulce extends Produs {
    private final TipAluat tipAluat;
    private final int numarToppinguri;

    public GofraDulce(String denumire, double pret, int stoc,
                     TipAluat tipAluat, int numarToppinguri) {
        super(denumire, pret, stoc);
        if (tipAluat == null || numarToppinguri < 0) {
            throw new IllegalArgumentException("Aluat sau numar de toppinguri invalid.");
        }
        this.tipAluat = tipAluat;
        this.numarToppinguri = numarToppinguri;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + tipAluat.getSuplimentPret() + 2.0 * numarToppinguri;
    }

    @Override
    public String toString() {
        return super.toString() + " [gofra dulce, aluat " + tipAluat
                + ", toppinguri: " + numarToppinguri + "]";
    }
}
