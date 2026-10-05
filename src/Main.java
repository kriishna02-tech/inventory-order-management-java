import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventory inventory = new Inventory();
        OrderManager orderManager = new OrderManager();

        inventory.addProduct(
                new Product(101, "Laptop", "Electronics", 75000, 5));

        inventory.addProduct(
                new Product(102, "Mouse", "Accessories", 800, 20));

        inventory.addProduct(
                new Product(103, "Keyboard", "Accessories", 2500, 8));

        inventory.addProduct(
                new Product(104, "Monitor", "Electronics", 15000, 3));

        inventory.addProduct(
                new Product(105, "USB Cable", "Cables", 400, 30));

        int choice;

        do {

            System.out.println("\n===== INVENTORY SYSTEM =====");
            System.out.println("1. Show all products");
            System.out.println("2. Search product");
            System.out.println("3. Show low stock");
            System.out.println("4. Sort by price");
            System.out.println("5. Show categories");
            System.out.println("6. Inventory value");
            System.out.println("7. Place order");
            System.out.println("8. Show next order");
            System.out.println("9. Process next order");
            System.out.println("10. Show pending orders");
            System.out.println("11. Show order history");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    inventory.showAllProducts();
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int searchId = sc.nextInt();

                    inventory.findProductById(searchId)
                            .ifPresentOrElse(
                                    product -> System.out.println(product),
                                    () -> System.out.println("Product not found"));

                    break;

                case 3:
                    System.out.print("Enter stock limit: ");
                    int limit = sc.nextInt();

                    inventory.showLowStockProducts(limit);
                    break;

                case 4:
                    inventory.sortByPrice();
                    break;

                case 5:
                    inventory.showCategories();
                    break;

                case 6:
                    System.out.println(
                            "Total inventory value: ₹"
                                    + inventory.calculateTotalInventoryValue());
                    break;

                case 7:

                    System.out.print("Enter order ID: ");
                    int orderId = sc.nextInt();

                    System.out.print("Enter product ID: ");
                    int productId = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();

                    Order order = new Order(
                            orderId,
                            productId,
                            customerName,
                            quantity);

                    orderManager.placeOrder(order);

                    System.out.println("Order placed.");

                    break;

                case 8:
                    orderManager.showNextOrder();
                    break;

                case 9:
                    orderManager.processNextOrder();
                    break;

                case 10:
                    orderManager.showPendingOrders();
                    break;

                case 11:
                    orderManager.showOrderHistory();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}