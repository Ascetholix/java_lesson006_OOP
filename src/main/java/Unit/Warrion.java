package Unit;

import java.util.ArrayList;

public abstract class Warrion extends  Person{

    public Warrion(String name, int attack, int def, int damageMin, int damageMax,
                   float hp, float maxHp, int speed, int posX, int posY) {
        super(name, attack, def, damageMin, damageMax, hp, maxHp, speed, posX, posY);
    }

    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {

    }
}
