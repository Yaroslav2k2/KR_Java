import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
                return;
            }
        }
        System.out.println("Игрушка с указанным ID не найдена.");
    }

    public void drawToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double random = Math.random() * totalFrequency;
        double sum = 0;
        Toy winner = null;
        for (Toy toy : toys) {
            sum += toy.getFrequency();
            if (random <= sum) {
                winner = toy;
                break;
            }
        }
        if (winner != null && winner.getQuantity() > 0) {
            winner.decreaseQuantity();
            prizeToys.add(winner);
            savePrizeToyToFile(winner);
            System.out.println("Поздравляем! Вы выиграли: " + winner.getName());
        } else {
            System.out.println("Извините, призовая игрушка не найдена или закончилась в наличии.");
        }
    }

    private void savePrizeToyToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("winners.txt", true)) {
            writer.write("Призовая игрушка: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
