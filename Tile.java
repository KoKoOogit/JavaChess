import java.util.ArrayList;

public class Tile {
    protected int x;
    protected int y;
    protected int startX;
    protected int startY;

    protected int rank;
    protected int file;
    protected Piece p;

    public Tile(int x, int y, int rank, int file) {
        this.startX = x;
        this.startY = y;
        this.rank = rank;
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
    
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public void setFile(int rank) {
        this.rank = rank;
    }

    public int getrank() {
        return this.rank;
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

    public void setPiece(Piece p){
        this.p = p;
    }

    public Piece getPiece() {
        return this.p;
    }

    public void removePiece() {
        this.p = null;
    }
}
