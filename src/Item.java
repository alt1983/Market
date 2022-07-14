public class Item extends Good {
    public int price;

    public Item(int id, String name, int price) {
        super(id, name);
        this.price = price;
    }
}
