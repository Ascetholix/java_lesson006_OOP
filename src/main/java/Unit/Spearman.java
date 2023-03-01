package Unit;
import Unit.Person;
import Unit.Warrion;

import java.util.ArrayList;

/**
 * Копейщик
 */
public class Spearman extends Warrion {

    public Spearman(String name, int posX, int posY) {
        super(name,14, 10, 2, 4,10f, 10f,4, posX, posY);
    }

    @Override

    public String getInfo(){ return "Копейщик";}
    public int getData() {
        return 0;
    }

    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (state.equals("Die")) return; // Проверка если сам жив
        // цикл проверки услови если все противники мертвы что бы дальше не ходить
        int countDie = 0;
        for (int i = 0; i < team2.size(); i++) {
            if (team2.get(i).state.equals("Die")) countDie++;
            if (countDie == team2.size()) return;
        }
 // y = 10
        int target = findNearest(team2);                  // Поиск ближайшего врага
        int enemyPosX = team2.get(target).getPosition()[0];   // позиция Х врага
        int enemyPosY = team2.get(target).getPosition()[1];   // позиция Y врага
        int countStep = 1;
        if (position.isLeft((team2.get(target).position))){     // условия проверка стороны
            if(!team2.get(target).state.equals("Die")){
                if (position.posX != enemyPosX ) setPosition(position.posX + countStep, position.posY);
                if (position.posY != enemyPosY ) setPosition(position.posX, position.posY - countStep);
            }
        }
        else {
            if (!team2.get(target).state.equals("Die")) {
                if (position.posX != enemyPosX) setPosition(position.posX - countStep, position.posY);
                if (position.posY != enemyPosY) setPosition(position.posX, position.posY - countStep);
            }
        }
        if(position.getDistance(team2.get(target).position) >= 1 ||  position.getDistance(team2.get(target).position) <=2 ){
            float damage = (team2.get(target).def -attack > 0)?
                    damageMin : (team2.get(target).def -attack < 0)?
                    damageMax : (damageMin+damageMax)/2;
            team2.get(target).getDamage(damage);
        }
    }
}
