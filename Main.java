public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        // Добавляем игрушки
        toyShop.addToy(new Toy(1, "Мяч", 10, 20));
        toyShop.addToy(new Toy(2, "Кукла", 15, 30));
        toyShop.addToy(new Toy(3, "Машинка", 20, 50));

        // Выполняем розыгрыш
        toyShop.drawToy();
    }
}
