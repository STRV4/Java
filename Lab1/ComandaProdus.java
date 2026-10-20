import java.util.Scanner;

// B3
public class ComandaProdus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produs[] produse = new Produs[4];
        produse[0] = new Produs("Zeama de casa", 24.50, 20);
        produse[1] = new Produs("Piure cu parjoala", 46.00, 15);
        produse[2] = new Produs("Salata de varza", 18.00, 10);
        produse[3] = new Produs("Compot", 12.00, 30);

        System.out.print("Denumirea produsului: ");
        String cautat = sc.nextLine();
        System.out.print("Numar de portii: ");
        int portii = sc.nextInt();

        boolean gasit = false;
        for (int i = 0; i < produse.length; i++) {
            if (produse[i].getDenumire().equals(cautat)) {
                gasit = true;
                if (produse[i].esteDisponibil(portii)) {
                    System.out.println("Cost: " + produse[i].costPentru(portii) + " lei");
                } else {
                    System.out.println("Stoc insuficient, mai sunt doar " + produse[i].getStoc() + " portii");
                }
            }
        }

        if (!gasit) {
            System.out.println("Produsul nu exista in meniu");
        }
    }
}
