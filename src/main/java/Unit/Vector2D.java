package Unit;

import java.util.ArrayList;

public class Vector2D {
    public int posX;
    public int posY;
    protected Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    protected double getDistance(Vector2D oponent){
        return Math.sqrt(Math.pow(this.posX - oponent.posX,2) + Math.pow(this.posY - oponent.posY,2));
    }
    protected boolean isLeft(Vector2D oponent){    // проверка влево
        if (this.posX < oponent.posX) return true;
        return false;
    }
    protected boolean isCell(ArrayList<Person> list){ // проверка пустая клетка
        for (int i = 0; i < list.size(); i++) {
            if(this.posX == list.get(i).position.posX && this.posY == list.get(i).position.posY) return true;
        }
        return false;
    }
}
