package Unit;
import Unit.Person;

import java.util.ArrayList;

/**
 * Фермер
 */
public class Farmer extends Person {
    int delivery;


    public Farmer(String name, int attack, int def, int damageMin, int damageMax, float hp,
                  float maxHp, int speed, int delivery, int posX, int posY) {
        super(name, attack, def, damageMin, damageMax, hp, maxHp, speed, posX, posY);
        this.delivery = delivery;
    }

    public Farmer(String name, int posX, int posY) {
        super(name, 1, 1, 1, 0, 1f, 1f, 3, posX, posY);
        this.delivery = 1;
        emoji = getEmoji("farmer");
    }

    public int getDelivery() {
        return delivery;
    }


    public String getInfo() {return emoji; }

    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (!this.state.equals("Die") && (this.delivery == 1)) {
            this.state = "Stand";
        }
        else if (this.state.equals("Die")) {
            emoji = "\uD83D\uDC80";
        }
    }

    public int getData() {
        return delivery;
    }

    public void setData(int delivery) {
        this.delivery = delivery;
    }

    public String toString() {
        return String.format("Имя: %7s Hp: %2d Def: %2d Attack: %2d Dem: %2d Deliver: %d %s x:%d y:%d ",
                name, Math.round(this.hp), this.def, this.attack, Math.round(Math.abs((damageMin + damageMax) / 2)), delivery, state, position.posX,position.posY);


    }
}
