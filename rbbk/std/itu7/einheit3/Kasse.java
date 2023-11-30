package rbbk.std.itu7.einheit3;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Kasse {
    public static void main(String[] args) {

        double[] prices = new double[5];
        boolean[] istKonsum = new boolean[5];


        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte fünf Preise eingeben und ob Konsumgut oder Grundbedarf:");

        for(int i = 0; i < prices.length; i++){
            System.out.println("Bitte Preis eingeben");
            prices[i] = scanner.nextDouble();
            System.out.println("Bitte Art des Produktes eingeben K (Konsumgut) oder G (Grundbedarf)");
            String temp = scanner.next();
            if(temp.toUpperCase().equals("K")) istKonsum[i] = true;
            else istKonsum[i] = false;

        }

        double ergebnis = addition(prices);

        final double result = (ergebnis*1.19);
        double tax = result-ergebnis;


        String zwiAusgabe = "Zwischensumme: ";
        String ausgabe = "Der Betrag inkl. Mwst ist: ";
        System.out.println(prices.length+" Artikel insgesamt");
        System.out.printf("Zwischensumme: %.2f\n",ergebnis);
        System.out.printf("Mwst: %.2f\n",calculateTax(prices,istKonsum));
        System.out.printf("Zwischensumme: %.2f\n",result);

    }
    static double addition(double[] prices){
        double sum = 0;
        for(int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum;
    }
    static double calculateTax(double[] prices,boolean[] konsum) {
        double result = 0;
        for (int i = 0; i < prices.length; i++) {
            if(konsum[i]) result += prices[i]*0.19;
            else result += prices[i]*0.07;
        }
        return result;
    }
}