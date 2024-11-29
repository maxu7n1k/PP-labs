package models;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract int attack();

    @Override
    public String toString() {
        return String.format("%s [Health: %d, Damage: %d]", name, health, damage);
    }
}
