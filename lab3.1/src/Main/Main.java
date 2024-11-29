package Main;

import battle.Battle;
import models.Droid;
import models.HealerDroid;
import models.WarriorDroid;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Droid> droids = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String lastBattleLog = ""; // Зберігає лог останнього бою

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create droid");
            System.out.println("2. Show droids");
            System.out.println("3. Start 1v1 battle");
            System.out.println("4. Start team battle");
            System.out.println("5. Save battle to file");
            System.out.println("6. Load battle from file");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> startOneOnOneBattle();
                case 4 -> startTeamBattle();
                case 5 -> saveBattle();
                case 6 -> loadBattle();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void createDroid() {
        System.out.print("Enter droid name: ");
        String name = scanner.nextLine();
        System.out.println("Choose droid type: 1. Warrior 2. Healer");
        int type = scanner.nextInt();
        scanner.nextLine();

        Droid droid = (type == 1) ? new WarriorDroid(name) : new HealerDroid(name);
        droids.add(droid);
        System.out.println("Droid created: " + droid);
    }

    private static void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("No droids created yet.");
        } else {
            for (int i = 0; i < droids.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, droids.get(i));
            }
        }
    }

    private static void startOneOnOneBattle() {
        if (droids.size() < 2) {
            System.out.println("Not enough droids for a battle!");
            return;
        }
        showDroids();
        System.out.print("Choose first droid: ");
        int d1 = scanner.nextInt() - 1;
        System.out.print("Choose second droid: ");
        int d2 = scanner.nextInt() - 1;

        StringBuilder battleLog = new StringBuilder();
        Droid droid1 = droids.get(d1);
        Droid droid2 = droids.get(d2);

        battleLog.append("Starting 1v1 battle: ").append(droid1.getName()).append(" vs ").append(droid2.getName()).append("\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            droid2.takeDamage(droid1.attack());
            battleLog.append(droid1.getName()).append(" attacks ").append(droid2.getName())
                    .append(". ").append(droid2.getName()).append("'s health: ").append(droid2.getHealth()).append("\n");

            if (!droid2.isAlive()) break;

            droid1.takeDamage(droid2.attack());
            battleLog.append(droid2.getName()).append(" attacks ").append(droid1.getName())
                    .append(". ").append(droid1.getName()).append("'s health: ").append(droid1.getHealth()).append("\n");
        }

        String winner = droid1.isAlive() ? droid1.getName() : droid2.getName();
        battleLog.append("Winner: ").append(winner).append("\n");

        System.out.println(battleLog); // Вивід бою в консоль
        lastBattleLog = battleLog.toString(); // Збереження логу в змінну
    }

    private static void startTeamBattle() {
        System.out.println("Team battle is not implemented yet.");
    }

    private static void saveBattle() {
        if (lastBattleLog.isEmpty()) {
            System.out.println("No battle log to save!");
            return;
        }

        System.out.print("Enter filename to save battle log: ");
        String filename = scanner.nextLine();

        FileUtils.writeToFile(filename, lastBattleLog);
        System.out.println("Battle log saved to " + filename);
    }

    private static void loadBattle() {
        System.out.print("Enter filename to load battle log: ");
        String filename = scanner.nextLine();

        String loadedLog = FileUtils.readFromFile(filename);
        if (loadedLog.isEmpty()) {
            System.out.println("No battle log found in the file.");
        } else {
            System.out.println("Loaded battle log:");
            System.out.println(loadedLog);
        }
    }
}
