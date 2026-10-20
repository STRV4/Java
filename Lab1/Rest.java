import java.util.Scanner;

// C1
public class Rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Suma de plata (lei): ");
        int deplata = sc.nextInt();
        System.out.print("Suma achitata (lei): ");
        int achitat = sc.nextInt();

        int rest = achitat - deplata;
        System.out.println("Rest: " + rest + " lei");

        int b500 = rest / 500;
        rest = rest % 500;
        int b200 = rest / 200;
        rest = rest % 200;
        int b100 = rest / 100;
        rest = rest % 100;
        int b50 = rest / 50;
        rest = rest % 50;
        int b20 = rest / 20;
        rest = rest % 20;
        int b10 = rest / 10;
        rest = rest % 10;
        int b5 = rest / 5;
        rest = rest % 5;
        int b1 = rest;

        System.out.println(b500 + " bancnote de 500");
        System.out.println(b200 + " bancnote de 200");
        System.out.println(b100 + " bancnote de 100");
        System.out.println(b50 + " bancnote de 50");
        System.out.println(b20 + " bancnote de 20");
        System.out.println(b10 + " bancnote de 10");
        System.out.println(b5 + " bancnote de 5");
        System.out.println(b1 + " bancnote de 1");
    }
}
