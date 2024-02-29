import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece{
  protected int rank;
  protected int file;
  protected Player player;
  protected String name;
  protected String icon;
  protected int points;
  protected Board b;
  protected Tile tile;
  
  public Piece(int rank, int file, Player player, String name, String icon, int points, Board b){
    this.rank = rank;
    this.file = file;
    this.player = player;
    this.name = name;
    this.icon = icon;
    this.points = points;
    this.b = b;

  }

  public int getRank(){
    return rank;
  }

  public int getFile(){
    return file;
  }

  public void updateTile(Tile tile){
    this.tile = tile;
  }

  public BufferedImage getImage(){
    BufferedImage image = null;
    try {
      image = ImageIO.read(new File(icon));
    } 
    catch(IOException except){
      except.printStackTrace();
    }
    return image;
  }
  
  public Player getPlayer(){
    return player;
  }
  
  public void setPlayer(Player p){
    this.player = p;
  }

  public boolean isValidMove(int rank, int file){
    return false;
  }
}