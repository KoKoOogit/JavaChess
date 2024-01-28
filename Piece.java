import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece{
  protected boolean isWhite;
  protected boolean isKilled;
  protected Player player;
  protected String icon_path;
  protected Board b;
  protected Tile tile;
  protected int rank;
  protected int file;


  public Piece(int rank, int file, Player p, String icon, Board b){
    this.rank = rank;
    this.file = file;
    this.icon_path = icon;
    this.player = p;
    this.b = b;

  }
  
  public void setPlayer(Player p) {
    this.player = p;
  }

  public BufferedImage getImage() {
    BufferedImage image = null;
    try {

      image = ImageIO.read(new File(icon_path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
   
  public boolean isValidMove(int rank, int file) {
    return false;
  }
   
  public void updateTile(Tile tile) {
    this.tile = tile;
  }

}