package Unit.pers;
import Unit.Warrion;

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

}
