package rbbk.std.itu7;
import java.util.Scanner;


public class Addition {

    static boolean DEBUG = false;
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
        double allPrice = sumPrice(products);
        System.out.println("Produktname-----Produktanzahl-----Produktpreis"+EURO);
        for(Product product:products) {
            System.out.println(""+product.name+"-----"+product.count+"-----"+getEuroPrice(product.price));
        }
        System.out.println("-----");
        System.out.println("Summe: "+getEuroPrice(allPrice));
        System.out.println("Anzahl: "+countProducts(products));
        System.out.println("Mehrwertsteuer: "+getEuroPrice(tax(allPrice)));
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
