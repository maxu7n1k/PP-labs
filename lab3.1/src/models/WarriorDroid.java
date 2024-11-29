package models;

public class WarriorDroid extends Droid {
    public WarriorDroid(String name) {

        super(name, 100, 25);
    }

    @Override
    public int attack() {

        return damage;
    }
}
