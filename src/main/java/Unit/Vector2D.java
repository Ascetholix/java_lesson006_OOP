package Unit;

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
    protected boolean isLeft(Vector2D oponent){
        if (this.posX < oponent.posX) return true;
        return false;
    }
}
