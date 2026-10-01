// A3 si C3
public class TestProdus {
    public static void main(String[] args) {

        Produs p1 = new Produs("Zeama de casa", 24.50, 20);
        Produs p2 = new Produs("Piure cu parjoala", 46.00, 15);
        Produs p3 = new Produs("Salata de varza", 18.00, 10);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // C3
        System.out.println("Cod scurt: " + p1.codScurt());
    }
}
