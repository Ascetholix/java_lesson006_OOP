package Unit;

import java.util.ArrayList;

/**
 * Абстрактный класс Стрелок
 */
public abstract class Shooter extends Person{

    public int shot;

    public int getShot() {
        return shot;
    }

    public Shooter(String name, int attack, int def, int damageMin, int damageMax,
                   float hp, float maxHp, int speed, int shot, int posX, int posY) {
        super(name, attack, def, damageMin, damageMax, hp, maxHp, speed, posX, posY);
        this.shot = shot;
    }

    //    Реализовать метод step() стрелков.
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        // цикл проверки услови если все противники мертвы что бы дальше не ходить
        int countDie = 0; // счетчик мертвых
        for (int i = 0; i < team2.size(); i++) {
            if(team2.get(i).state.equals("Die")) countDie++;
            if(countDie == team2.size()) return;
        }

        if (state.equals("Die") || shot == 0) return;           //  3.1 Если жизнь равна нулю или стрел нет, завершить обработку.
        int target = findNearest(team2);                        // 3.2 Поиск среди противников наиболее приближённого. мин макс и сред повреждние
        float damage = (team2.get(target).def -attack > 0)?     // 3.3 Нанести  повреждение найденному противнику.
                damageMin : (team2.get(target).def -attack < 0)?
                damageMax : (damageMin + damageMax)/2;

        if(!team2.get(target).state.equals("Die")) team2.get(target).getDamage(damage);  // происвоит опоненту если он жив

        for (int i = 0; i < team1.size(); i++) {                // поиск фермара по getInfo и состяную state
            if (team1.get(i).getInfo().equals("Фермер") && team1.get(i).state.equals("Stand")){
                team1.get(i).state = "Busy";
                team1.get(i).setData(0);                         // если условия соcтoяние Stand то доставка 0 состояние Busy и выход
                return;
            }
        }
        for (int i = 0; i < team1.size(); i++) {             // если состояние Busy то доставка 1 состояние Stand
            if (team1.get(i).getInfo().equals("Фермер") && team1.get(i).state.equals("Busy")) {
                team1.get(i).setData(1);
                team1.get(i).state = "Stand";;
            }
        }
        shot--;                                                  //    3.5 Если найден завершить метод иначе уменьшить запас стрел на одну.
    }

    public String toString() {
        return String.format("Имя: %7s Hp: %2d Def: %2d Attack: %2d Dem: %2d Shots: %2d %s x:%d y:%d ",
                name,Math.round(hp), def,attack,Math.round(Math.abs((damageMin+damageMax)/2)),shot, state, position.posX,position.posY);

    }
}
