// Lab1 - A3 si C3; Lab2 - C1
public class TestProdus {
    public static void main(String[] args) {

        Produs p1 = new Produs("Zeama de casa", 24.50, 20);
        Produs p2 = new Produs("Piure cu parjoala", 46.00, 15);
        Produs p3 = new Produs("Salata de varza", 18.00, 10);

        Produs p4 = new Produs("Compot", 12.00, 30);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println("Numar produse: " + Produs.getNumarProduse());

        // C3
        System.out.println("Cod scurt: " + p1.codScurt());
    }
}
