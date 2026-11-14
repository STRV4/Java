package lab3;

public class GofraDulcePremium extends GofraDulce {
    private final double suplimentCrema;

    public GofraDulcePremium(String denumire, double pret, int stoc,
                            TipAluat tipAluat, int numarToppinguri, double suplimentCrema) {
        super(denumire, pret, stoc, tipAluat, numarToppinguri);
        if (!Double.isFinite(suplimentCrema) || suplimentCrema < 0) {
            throw new IllegalArgumentException("Suplimentul pentru crema este invalid.");
        }
        this.suplimentCrema = suplimentCrema;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + suplimentCrema;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                " [premium, supliment crema: %.2f lei]", suplimentCrema);
    }
}
