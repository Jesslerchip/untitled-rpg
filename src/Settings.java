import java.io.Serializable;

public class Settings implements Serializable {

    private int x, y; // Dimensions for a GUI window

    public Settings(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
