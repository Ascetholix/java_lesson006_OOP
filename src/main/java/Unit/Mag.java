package Unit;

import Unit.Sorcerer;

/**
 * Колдун
 */
public class Mag extends Sorcerer {

    public Mag(String name, int posX, int posY) {
        super(name,17, 12, -5, 0,30f,30f, 5, 1, posX, posY);
        emoji = "\uD83E\uDDD9";
    }

    public String getInfo(){return emoji;}

    public int getData() {
        return magic;
    }
    public void setData(int magic){
        this.magic = magic;
    }


}
