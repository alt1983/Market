import java.util.ArrayList;
import java.util.List;

public class OrderList implements Showable {
    private Client client;
    private List<Order> orders;

    public OrderList(Client client) {
        this.client = client;
        this.orders = new ArrayList<>();
    }

    public String show() {

        String show = "Список заказов\n";
        for (Order o : orders) {
            show += "Заказ на сумму: " + o.getSumm() + " Статус: " + o.status + "\n";
        }
        return show;

    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

}
