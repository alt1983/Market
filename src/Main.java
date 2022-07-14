import java.util.Scanner;

public class Main {

    public static void printMainMenu() {
        System.out.println("Добро пожалодать в магазин Market! Выберите дейтсвие:");
        System.out.println("1. Показать каталог товаров");
        System.out.println("2. Сделать заказ");
        System.out.println("3. Показать Ваши заказы");
        System.out.println("4. Выйти\n");
    }

    public static void printSaleMenu() {

        System.out.println("Введите код товара для добавления в заказ:");
        System.out.println("5.Выйти в основное меню");
        System.out.println("6.Оплатить");
        System.out.println("7.Доставить");
        System.out.println("8.Посмотреть состав заказа\n");
    }

    public static void printGoodInfo(Good good) {
        System.out.println(good.getName());
    }

    public static void main(String[] args) {

        Client client = new RussianCitizen(1111111111, "Иван", "777", "Moscow");
        Catalogue catalogue = new Catalogue("Каталог спортивных товаров");
        catalogue.addItem(new Item(101, "Лыжи", 10000), 10);
        catalogue.addItem(new Item(102, "Санки", 5000), 20);
        catalogue.addItem(new Item(103, "Мяч", 1000), 30);
        OrderList orders = new OrderList(client);
        printMainMenu();
        System.out.println("В продаже имеются: ");
        for (var entry : catalogue.goods.entrySet()) {
            printGoodInfo(entry.getKey());
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            if (x == 1) System.out.println(catalogue.show());

            if (x == 2) {
                Order order = new Order(client);
                orders.addOrder(order);
                printSaleMenu();
                while (true) {
                    Scanner scan = new Scanner(System.in);
                    int y = scanner.nextInt();
                    if (y == 5) {
                        printMainMenu();
                        break;
                    }
                    if (y == 6) order.paid();
                    if (y == 7) order.delivered();
                    if (y == 8) System.out.println(order.show());
                    for (var entry : catalogue.goods.entrySet()) {
                        if (y == entry.getKey().getId()) {
                            int j = catalogue.goods.get(entry.getKey());
                            if (j > 0) {
                                j--;
                                catalogue.goods.put(entry.getKey(), j);
                                order.addItem(entry.getKey());
                            }
                        }
                    }

                }
            }
            if (x == 3) System.out.println(orders.show());
            if (x == 4) break;
        }

    }
}
