package Unit;

import java.util.ArrayList;

/**
 * Абстрактный класс Черодей
 */
public abstract class Sorcerer extends Person {
    public int magic;

    public int getMagic() {
        return magic;
    }


    public Sorcerer(String name, int attack, int def, int damageMin, int damageMax,
                    float hp, float maxHp, int speed, int magic, int posX, int posY) {
        super(name, attack, def, damageMin, damageMax, hp, maxHp, speed, posX, posY);
        this.magic = magic;
    }

//    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
//        if (state.equals("Die") || magic == 0) return;
//        int target = treatmentNearest(team1);
//        float damage = team1.get(target).def - this.attack;
//        if(!team1.get(target).state.equals("Die")) team1.get(target).getDamage(damage);// происвоит
//    }

    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        for (Person person : team1) {
            if (person.hp < person.maxHp) {
                person.getDamage(damageMin);
                break;   // что бы выходил после первой проверки
            }
        }
    }

    public String toString() {
        return String.format("Имя: %7s Hp: %2d Def: %2d Attack: %2d Dem: %d Magic: %2d %s ",
                name, Math.round(hp), def, attack, Math.round(Math.abs((damageMin + damageMax) / 2)), magic, state);


    }
}