package models;

import java.util.Random;

public class HealerDroid extends Droid {
    private final Random random = new Random();

    public HealerDroid(String name) {
        super(name, 80, 15); // Встановлюємо здоров'я = 80, шкоду = 15
    }

    @Override
    public int attack() {
        // Повертає значення шкоди
        return damage;
    }

    public void heal(Droid ally) {
        if (ally != null && ally.isAlive()) {
            int healing = random.nextInt(15) + 5; // Рандомне зцілення від 5 до 20
            ally.health += healing;
            System.out.printf("%s heals %s for %d health points!%n", name, ally.getName(), healing);
        }
    }
}
