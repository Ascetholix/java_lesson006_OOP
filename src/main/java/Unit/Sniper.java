package Unit;
import Unit.Shooter;

/**
 * Снайпер
 */
public class Sniper extends Shooter{

    public Sniper(String name, int posX, int posY){
        super(name,6, 3, 2,3,15f,15f, 4, 16, posX, posY);
        emoji = "\uD83C\uDFF9";
    }

    public String getInfo(){return emoji;}
    public int getData() {
        return shot;
    }
    public void setData(int shot){
        this.shot = shot;
    }

}


