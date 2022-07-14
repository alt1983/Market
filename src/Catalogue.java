import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogue implements Showable {
    public String name;
    public Map<Item, Integer> goods;

    public String show() {
        String show = this.name + "\n";
        for (var entry : this.goods.entrySet()) {
            show = show + "Код: " + entry.getKey().getId() + " Название: " + entry.getKey().getName() + " Цена: " + entry.getKey().price + " Количество: " + entry.getValue() + "\n";
        }
        return show;
    }


    public Catalogue(String name) {
        this.name = name;
        this.goods = new HashMap<>();
    }

    public void addItem(Item item, Integer qt) {
        this.goods.put(item, qt);
    }

    public Integer getItemQt(Item item) {
        return this.goods.get(item);

    }

    public Item getItem(int id) {
        Item item = null;
        for (var entry : this.goods.entrySet()) {
            if (entry.getKey().getId() == id) {
                item = entry.getKey();
            }
        }
        return item;
    }


}
