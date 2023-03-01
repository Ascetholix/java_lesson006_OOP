package Unit;

public class Vector2D {
    public int posX;
    public int posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public double getDistance(Vector2D oponent){
        return Math.sqrt(Math.pow(this.posX - oponent.posX,2) + Math.pow(this.posY - oponent.posY,2));
    }
}
