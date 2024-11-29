package battle;

import models.Droid;

import java.util.List;

public class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2) {
        System.out.println("Battle starts: " + droid1.getName() + " VS " + droid2.getName());
        while (droid1.isAlive() && droid2.isAlive()) {
            droid2.takeDamage(droid1.attack());
            System.out.printf("%s attacks %s. %s's health: %d%n", droid1.getName(), droid2.getName(), droid2.getName(), droid2.getHealth());

            if (!droid2.isAlive()) break;

            droid1.takeDamage(droid2.attack());
            System.out.printf("%s attacks %s. %s's health: %d%n", droid2.getName(), droid1.getName(), droid1.getName(), droid1.getHealth());
        }

        System.out.println(droid1.isAlive() ? droid1.getName() + " wins!" : droid2.getName() + " wins!");
    }

    public static void teamBattle(List<Droid> team1, List<Droid> team2) {
        System.out.println("Team battle starts!");
        while (team1.stream().anyMatch(Droid::isAlive) && team2.stream().anyMatch(Droid::isAlive)) {
            Droid attacker1 = team1.stream().filter(Droid::isAlive).findFirst().orElse(null);
            Droid attacker2 = team2.stream().filter(Droid::isAlive).findFirst().orElse(null);

            if (attacker1 != null && attacker2 != null) {
                attacker2.takeDamage(attacker1.attack());
                System.out.printf("%s attacks %s. %s's health: %d%n", attacker1.getName(), attacker2.getName(), attacker2.getName(), attacker2.getHealth());

                if (!attacker2.isAlive()) continue;

                attacker1.takeDamage(attacker2.attack());
                System.out.printf("%s attacks %s. %s's health: %d%n", attacker2.getName(), attacker1.getName(), attacker1.getName(), attacker1.getHealth());
            }
        }

        System.out.println(team1.stream().anyMatch(Droid::isAlive) ? "Team 1 wins!" : "Team 2 wins!");
    }
}
