package rbbk.std.itu7.einheit1;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Addition {

    static boolean DEBUG = true;
    public static final String EURO = "\u20AC";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if(DEBUG) {
            printer(template);
            scanner.nextLine();
            scanner.close();
            return;
        }
        
        System.out.println("Bitte 5 Produkte eingeben:");
        Product[] products = new Product[5];
        for(int index = 0;index<products.length;index++) {
            System.out.println("Bitte Produktnamen eingeben:");
            String name = scanner.next();
            System.out.println("Bitte Produktanzahl eingeben:");
            int count = scanner.nextInt();
            System.out.println("Bitte Produktpreis in Euro mit Komma eingeben:");
            double price = scanner.nextDouble();
            products[index] = new Product(name,count,price);
        }
        
        printer(products);
        scanner.close();
        
    }
    public static void printer(Product[] products) {
        javax.swing.JWindow window = new JWindow();
        window.setSize(800,600);
        window.setName("Hurray");
        window.setVisible(true);
        TextArea area = new TextArea();
        window.add(area);
        area.append(outputString(products));
        area.setVisible(true);
        window.validate();
        System.out.println(outputString(products));


    }
    private static String outputString(Product[] products) {
        double allPrice = sumPrice(products);
        String result ="Produktname-----Produktanzahl-----Produktpreis in "+EURO+"\n" +
                "-----\n";
        for(Product product:products) {
            result += product.name+"-----"+product.count+"-----"+getEuroPrice(product.price)+"\n";
        }
        result += "-----\n"+
                "Summe: "+getEuroPrice(allPrice)+"\n" +
                "Anzahl: "+countProducts(products)+"\n" +
                "Mehrwertsteuer: "+getEuroPrice(tax(allPrice))+"\n";

        return result;
    }
    private static int countProducts(Product[] products) {
        int sumCount = 0;
        for (Product prod : products) {
            sumCount += prod.count;
        }
        return sumCount;
    }
    private static double sumPrice(Product[] products) {
        double sumPrice = 0.0;
        for (Product prod : products) {
            sumPrice += prod.price*prod.count;
        }
        return sumPrice;
    }
    private static double tax(double price) {
        return price*0.19;
    }
    private static Product[] template = {
        new Product("a",1,2.51),
        new Product("b",2,3),
        new Product("c",3,4),
        new Product("d",4,5),
        new Product("e",5,6),
    };
    private static String getEuroPrice(double price) {
        return String.format("%.2f"+EURO,price);
    }

}
