import java.util.HashMap;
import java.util.Map;

public class Order implements Payable, Deliverable {
    public Client client;
    public Status status;
    public Map<Item, Integer> goods;

    public Order(Client client) {
        this.client = client;
        this.status = Status.PROCESS;
        this.goods = new HashMap<>();
    }

    public void addItem(Item item) {
        if (goods.get(item) != null) {
            int j = goods.get(item);
            j++;
            goods.put(item, j);
        } else {
            goods.put(item, 1);
        }
        System.out.println("Товар " + item.getName()+ " добавлен!");

    }

    public String show() {
        String show = "Ваш Заказ: " + this.status + "\n";
        for (var entry : this.goods.entrySet()) {
            show = show + "Код: " + entry.getKey().getId() + " Название: " + entry.getKey().getName() + " Цена: " + entry.getKey().price + " Количество: " + entry.getValue() + "\n";
        }
        show += "СУММА:" + this.getSumm();
        return show;
    }

    public int getSumm() {
        int sum = 0;
        for (var entry : this.goods.entrySet()) {
            sum = sum + entry.getKey().price * entry.getValue();
        }
        return sum;
    }

    @Override
    public void paid() {
        status = Status.PAID;
        System.out.println("Заказ оплачен");
    }

    @Override
    public void delivered() {
        status = Status.DELIVERED;
        System.out.println("Заказ передан в доставку");
    }

}
