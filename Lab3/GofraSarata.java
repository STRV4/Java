package lab3;

public class GofraSarata extends Produs {
    private final TipAluat tipAluat;
    private final boolean portieDublaBranza;

    public GofraSarata(String denumire, double pret, int stoc,
                      TipAluat tipAluat, boolean portieDublaBranza) {
        super(denumire, pret, stoc);
        if (tipAluat == null) {
            throw new IllegalArgumentException("Tipul aluatului este obligatoriu.");
        }
        this.tipAluat = tipAluat;
        this.portieDublaBranza = portieDublaBranza;
    }

    @Override
    public double pretFinal() {
        return super.pretFinal() + tipAluat.getSuplimentPret() + (portieDublaBranza ? 5 : 0);
    }

    @Override
    public String toString() {
        return super.toString() + " [gofra sarata, aluat " + tipAluat
                + ", portie dubla de branza: " + (portieDublaBranza ? "da" : "nu") + "]";
    }
}
