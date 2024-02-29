import java.lang.Math;

public class Knight extends Piece {

  //constructor for knight that assigns attributes
  public Knight(int r, int file, Player player, String name, String iconPath, int points, Board board){
    super(r, file, player, name, iconPath, points, board);
  }
  @Override
  public boolean isValidMove(int pressRank, int pressFile){
    int diffFile = Math.abs(pressFile - file);
    int diffRank = Math.abs(pressRank - rank);
    //checks if the knight is moving in an L
    if (diffFile == 2 && diffRank == 1 || diffFile == 1 && diffRank == 2){
      return true;
    }
    return false; 
  }
}
