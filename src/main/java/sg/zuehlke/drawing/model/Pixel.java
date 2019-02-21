package sg.zuehlke.drawing.model;

/**
 * Created by celineheldner on 19.02.19.
 */
public class Pixel {
    private int x;
    private int y;

    public Pixel(int xCoord, int yCoord){
        this.x = xCoord;
        this.y = yCoord;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pixel pixel = (Pixel) o;

        if (this.x != pixel.getX()) return false;
        return this.y == pixel.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
}
