import java.awt.Color;
import java.awt.Graphics;

public class Board {
  protected Player current_player;
  //white, black
  protected Player[] players;
  private Color c1 = new Color(210, 165, 125);
  private Color c2 = new Color(175, 115, 70);

  public int tileDimension = 50;
  private Tile[][] tiles = new Tile[8][8];

  public Board() {
    addTiles();
    this.current_player = players[0];
  }
  //initiate b by adding players ( white as index 0 )
  public Board(Player[] players) {
    this.players = players;
    this.current_player = players[0];
    addTiles();
  }

  public Board(Color c1, Color c2, int dimension, int tileDimension) {
    this.tileDimension = dimension;
    this.c1 = c1;
    this.c2 = c2;
    addTiles();
  }

  public void draw(Graphics g){
    for(Tile[] s : tiles){
      for (Tile t : s){
        Color c = (t.rank + t.file) % 2 == 0 ? c1 : c2;
        g.setColor(c);
        g.fillRect(t.startX, t.startY, tileDimension, tileDimension);
        if (t.getPiece() != null){
          g.drawImage(t.getPiece().getImage(), t.startX, t.startY, null);
        }
      }
    }
  }

  //add tiles to Tiles
  private void addTiles(){
    for (int file = 0; file < 8; file += 1){
      for (int rank = 0; rank < 8; rank += 1){
        this.tiles[rank][file] = new Tile(rank * tileDimension, file * tileDimension, rank, file);
      }
    }
  }

  //return the tiles
  public Tile[][] getTiles() {
    return this.tiles;
  }

  //get a specfic tile
  public Tile getTile(int r, int f) {
    if (r < 8 && f < 8) {
      return this.tiles[r][f];
    }
    return null;
  }
  //switch turn
  public void switchPlayer() {
    if (current_player == players[0]) {
      current_player = players[1];
    } else {
      current_player = players[0];
    }
  }

  //returns Player which is not his turn
  public Player getNotTurnPlayer() {
    if (current_player == players[0]) {
      return players[1];
    } else {
      return players[0];
    }
  }

}
