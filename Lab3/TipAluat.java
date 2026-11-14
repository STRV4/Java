package lab3;

public enum TipAluat {
    CLASIC(0),
    CACAO(3),
    INTEGRAL(2);

    private final double suplimentPret;

    TipAluat(double suplimentPret) {
        this.suplimentPret = suplimentPret;
    }

    public double getSuplimentPret() {
        return suplimentPret;
    }
}
