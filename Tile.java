import java.util.ArrayList;

public class Tile {
    protected int x;
    protected int y;
    protected int startX;
    protected int startY;

    protected int row;
    protected int file;

    public Tile(int x, int y, int row, int file) {
        this.startX = x;
        this.startY = y;
        this.row = row;
        this.file = file;
       
    }
    //returns the center point of a tile in arrayList (x,y)
    public ArrayList<Integer> getCenter(int tileWidth) {

        this.x = (this.startX + tileWidth) / 2;
        this.y = (this.startX + tileWidth) / 2;
        ArrayList<Integer> center = new ArrayList<Integer>();
        center.add(this.x);
        center.add(this.y);
        return center;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setFile(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int getFile() {
        return this.file;
    }
    
    public int getStartX() {
        return this.startX;
    }
    
    public int getStartY() {
        return this.startY;
    }
}
