package lab3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MeniuCombo extends Produs {
    private ArrayList<Produs> componente = new ArrayList<>();

    public MeniuCombo(String denumire, List<Produs> produse) {
        super(denumire, 0);
        if (produse == null || produse.isEmpty()) {
            throw new IllegalArgumentException("Combo-ul trebuie sa aiba componente.");
        }
        for (Produs produs : produse) {
            if (produs == null || produs instanceof MeniuCombo || componente.contains(produs)) {
                throw new IllegalArgumentException("Componentele trebuie sa fie produse distincte.");
            }
            componente.add(produs);
        }
    }

    public ArrayList<Produs> getComponente() {
        return componente;
    }

    private BigDecimal sumaComponente() {
        BigDecimal suma = BigDecimal.ZERO;
        for (Produs produs : componente) {
            suma = suma.add(BigDecimal.valueOf(produs.pretFinal()));
        }
        return suma.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public double getPret() {
        return sumaComponente().doubleValue();
    }

    @Override
    public double pretFinal() {
        return sumaComponente().multiply(BigDecimal.valueOf(100 - ZiLaStand.REDUCERE_COMBO))
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getStoc() {
        int stoc = componente.get(0).getStoc();
        for (Produs produs : componente) {
            stoc = Math.min(stoc, produs.getStoc());
        }
        return stoc;
    }

    @Override
    void scadeStoc(int cantitate) {
        if (!esteDisponibil(cantitate)) {
            throw new IllegalArgumentException("Stoc insuficient pentru combo.");
        }
        for (Produs produs : componente) {
            produs.scadeStoc(cantitate);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [combo, reducere " + ZiLaStand.REDUCERE_COMBO + "%]";
    }
}
