
import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Ecommerce {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product(1, "Laptop", 50000),
            new Product(2, "Mobile", 20000),
            new Product(3, "Headphones", 1500),
            new Product(4, "Keyboard", 1000)
        };

        ArrayList<Product> cart = new ArrayList<>();

        while (true) {
            System.out.println("\n===== E-COMMERCE STORE =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products) {
                        System.out.println(
                            p.id + ". " + p.name + " - Rs." + p.price
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == id) {
                            cart.add(p);
                            System.out.println(p.name + " added to cart!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    double total = 0;
                    System.out.println("\nYour Shopping Cart:");

                    for (Product p : cart) {
                        System.out.println(p.name + " - Rs." + p.price);
                        total += p.price;
                    }

                    System.out.println("Total: Rs." + total);
                    break;

                case 4:
                    double bill = 0;

                    for (Product p : cart) {
                        bill += p.price;
                    }

                    System.out.println("Order Placed Successfully!");
                    System.out.println("Total Amount: Rs." + bill);
                    cart.clear();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

