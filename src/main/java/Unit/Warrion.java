package Unit;

import java.util.ArrayList;

public abstract class Warrion extends  Person{

    public Warrion(String name, int attack, int def, int damageMin, int damageMax,
                   float hp, float maxHp, int speed, int posX, int posY) {
        super(name, attack, def, damageMin, damageMax, hp, maxHp, speed, posX, posY);
    }

    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {

        int countDie = 0;
        for (int i = 0; i < team2.size(); i++) {
            if (team2.get(i).state.equals("Die")) countDie++;
            if (countDie == team2.size()) return;
        }

        if (state.equals("Die")) return;
        int target = findNearest(team2);
        float damage = (team2.get(target).def -attack > 0)?
                damageMin : (team2.get(target).def -attack < 0)?
                damageMax : (damageMin+damageMax)/2;

        if(!team2.get(target).state.equals("Die")) team2.get(target).getDamage(damage);;

    }
}
