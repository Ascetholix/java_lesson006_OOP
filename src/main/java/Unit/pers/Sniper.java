package Unit.pers;
import Unit.Shooter;

/**
 * Снайпер
 */
public class Sniper extends Shooter {

    public Sniper(String name, int posX, int posY){
        super(name,6, 3, 2,3,15f,15f, 4, 16, posX, posY);
    }

    public String getInfo(){ return "Снайпер";}
    public int getData() {
        return shot;
    }
    public void setData(int shot){
        this.shot = shot;
    }

}


