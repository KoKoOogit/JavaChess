import java.util.ArrayList;

public class Player {
  private String color;
  private ArrayList<Piece> capturedPieces = new ArrayList<Piece>();
  private ArrayList<Piece> lostPieces = new ArrayList<Piece>();

  public Player(String color){
    this.color = color;
  }
  
  public void addCapturedPiece(Piece p) {
    this.capturedPieces.add(p);
  }

  public ArrayList<Piece> getCapturedPieces() {
    return this.capturedPieces;
  }

  public String getPlayerColor(){
    return this.color;
  }
}

