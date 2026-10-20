// Lab1 - A3, B3, C3; Lab2 - C1 si C3
public class Produs {
    private static int numarProduse = 0;
    private String denumire;
    private double pret;
    private int stoc;

    public Produs(String denumire, double pret, int stoc) {
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        numarProduse++;
    }

    public static int getNumarProduse() {
        return numarProduse;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    // Lab2 - C3: pretul se modifica doar pentru valori pozitive.
    public void setPret(double pret) {
        if (pret > 0) {
            this.pret = pret;
        }
    }

    public int getStoc() {
        return stoc;
    }

    // B3 costul pentru un anumit numar de portii
    public double costPentru(int portii) {
        return pret * portii;
    }

    // B3 verifica daca avem destule portii in stoc
    public boolean esteDisponibil(int portii) {
        return portii <= stoc;
    }

    // C3 primele 3 litere mari + partea intreaga a pretului
    public String codScurt() {
        String litere = denumire.substring(0, 3).toUpperCase();
        int parteIntreaga = (int) pret;
        return litere + parteIntreaga;
    }

    @Override
    public String toString() {
        return denumire + " - " + pret + " lei (stoc: " + stoc + ")";
    }
}
