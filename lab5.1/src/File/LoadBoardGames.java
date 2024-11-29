package File;

import Toy.BoardGames;
import Toy.Toy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoadBoardGames implements ToyLoader {
    private final String fileName = "C:\\Users\\solij\\OneDrive\\Рабочий стол\\BoardGame.txt";
    private List<Toy> toys;

    public LoadBoardGames(List<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                BoardGames game = new BoardGames(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                        data[4], Integer.parseInt(data[5]), data[6], data[7], Integer.parseInt(data[8]),
                        Integer.parseInt(data[9]), Integer.parseInt(data[10]));
                toys.add(game);
            }
            System.out.println("Настільні ігри завантажено з " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка зчитування файлу " + fileName);
        }
    }
}