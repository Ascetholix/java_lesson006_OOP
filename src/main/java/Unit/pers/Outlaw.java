package Unit.pers;
import Unit.Warrion;

/**
 * Разбойник
 */
public class Outlaw extends Warrion {

    public Outlaw(String name, int posX, int posY) {
        super(name, 14, 10, 2, 4, 10f, 10f, 4, posX, posY);

    }

    public String getInfo(){ return "Разбойник";}
    public int getData() {
        return 0;
    }
}
