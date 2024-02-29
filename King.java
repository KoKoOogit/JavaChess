import java.lang.Math;

public class King extends Piece {

  public King(int rank, int file, Player player, String name, String iconPath, int points, Board board) {
      super(rank, file, player, name, iconPath, points, board);
  }
  @Override
  public boolean isValidMove(int pressRank, int pressFile){
    int diffFile = Math.abs(pressFile - file);
    int diffRank = Math.abs(pressRank - rank);

    //checks if the king is only moving one space
    if (diffFile == 0 && diffRank == 1 || diffFile == 1 && diffRank == 0 || diffFile == 1 && diffRank == 1){
      return true;
    }
    return false; 
  }
}
