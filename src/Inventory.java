import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    
    public void addProduct(Product p) {
        products.put(p.getId(), p);
    }

    
    public void removeProduct(int id) {
        products.remove(id);
    }

    
    public void showAllProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }

    
    public Optional<Product> findProductById(int id) {

        Product p = products.get(id);

        if (p != null) {
            return Optional.of(p);
        }

        return Optional.empty();
    }

    
    public void showLowStockProducts(int limit) {

        for (Product p : products.values()) {

            if (p.getStock() < limit) {
                System.out.println(p);
            }
        }
    }

    
    public void showCategories() {

        HashSet<String> categories = new HashSet<>();

        for (Product p : products.values()) {
            categories.add(p.getCategory());
        }

        for (String category : categories) {
            System.out.println(category);
        }
    }

    
    public void sortByPrice() {

        ArrayList<Product> list =
                new ArrayList<>(products.values());

        list.sort(
                (p1, p2) ->
                        Double.compare(
                                p1.getPrice(),
                                p2.getPrice()
                        )
        );

        for (Product p : list) {
            System.out.println(p);
        }
    }

    
    public void sortByName() {

        ArrayList<Product> list =
                new ArrayList<>(products.values());

        list.sort(
                (p1, p2) ->
                        p1.getName()
                                .compareToIgnoreCase(p2.getName())
        );

        for (Product p : list) {
            System.out.println(p);
        }
    }

    public double calculateTotalInventoryValue() {

        return products.values()
                .stream()
                .map(p -> p.getPrice() * p.getStock())
                .reduce(0.0, (a, b) -> a + b);
    }
}