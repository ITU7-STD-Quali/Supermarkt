package rbbk.std.itu7.einheit3;

import java.util.Scanner;

public class KasseAlternativ {
    double summe = 0.0;
    double mwst = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte fünf Preise eingeben und ob Konsumgut oder Grundbedarf:");

        double p1 = price(scanner);
        String t1 = typ(scanner);
        double p2 = price(scanner);
        String t2 = typ(scanner);
        double p3 = price(scanner);
        String t3 = typ(scanner);
        double p4 = price(scanner);
        String t4 = typ(scanner);
        double p5 = price(scanner);
        String t5 = typ(scanner);

        double summe = summe(p1,p2,p3,p4,p5);
        double mwst = mwt(p1,t1);
        mwst += mwt(p2,t2);
        mwst += mwt(p3,t3);
        mwst += mwt(p4,t4);
        mwst += mwt(p5,t5);


        System.out.printf("Summe %.2f\n",summe);
        System.out.printf("MWST: %.2f\n",mwst);

    }

    public static double price(Scanner scanner) {
        System.out.println("Bitte geben sie einen Preis ein");
        double price = scanner.nextDouble();
        return price;
    }

    public static String typ(Scanner scanner) {
        System.out.println("Bitte Art des Produktes eingeben K (Konsumgut) oder G (Grundbedarf)");
        return scanner.next();
    }
    public static double summe(double p1,double p2,double p3,double p4,double p5) {
        return p1+p2+p3+p4+p5;
    }
    public static double mwt(double p,String t) {
        if(t.toUpperCase().equals("G")) return p*0.07;
        else return p*0.19;
    }


}
