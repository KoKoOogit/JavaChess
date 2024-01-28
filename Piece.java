public class Piece{
  private boolean isWhite;
  private boolean isKilled;

  private int[] position = new int[2];


  public Piece(int rank, int file){
    this.position[0] = rank;
    this.position[1] = file;
  }
  
}