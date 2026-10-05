import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class OrderManager {

    Queue<Order> orderList = new LinkedList<>();
    Deque<Order> orderHistory = new ArrayDeque<>();

    public void placeOrder(Order order) {
        orderList.offer(order);
    }

    public void showNextOrder() {
        System.out.println(orderList.peek());
    }

    public void processNextOrder() {

        Order processedOrder = orderList.poll();

        if (processedOrder != null) {
            orderHistory.offerLast(processedOrder);
            System.out.println("Processed: " + processedOrder);
        }
    }

    public void showPendingOrders() {
        System.out.println(orderList);
    }

    public void showOrderHistory() {
        System.out.println(orderHistory);
    }
}