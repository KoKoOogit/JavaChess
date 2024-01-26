import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Board {
    private Color c1 = new Color(210, 165, 125);
    private Color c2 = new Color(175, 115, 70);

    private int tileDimension = 50;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    public Board() {
        addTiles();
    }
   
    public Board(Color c1, Color c2, int dimension, int tileDimension) {
        this.tileDimension = dimension;
        this.c1 = c1;
        this.c2 = c2;
        addTiles();
    }

    public void draw(Graphics g) {
        for (Tile t : tiles) {
            Color c = (t.row + t.file) % 2 == 0 ? c1 : c2;
            g.setColor(c);
            g.fillRect(t.startX, t.startY, tileDimension, tileDimension);

        }
    }

    //add tiles to Tiles
    private void addTiles() {
        for (int file = 0; file < 8; file += 1) {
            for (int row = 0; row < 8; row += 1) {
                this.tiles.add(new Tile(row * tileDimension, file * tileDimension, row, file));
            }
        }
    }
    //return the tiles
    public ArrayList<Tile> getTiles() {
        return this.tiles;
    }

   

}
