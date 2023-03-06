package Unit;

import Unit.Sorcerer;

/**
 * Монах
 */
public class Monk extends Sorcerer {

    public Monk(String name, int posX, int posY) {
        super( name,12, 12, -5, 0,30f,30f, 5, 1,posX, posY);
        emoji = "\uD83E\uDDD9";
    }
    public String getInfo(){ return emoji;}

    public int getData() {return magic;}

    public void setData(int magic){
        this.magic = magic;
    }

}
