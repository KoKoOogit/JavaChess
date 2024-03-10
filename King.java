import java.lang.Math;

public class King extends Piece {

  private boolean hasMoved;

  //constructor for king that assigns attributes
  public King(int rank, int file, Player player, String name, String iconPath, int points, Board board) {
    super(rank, file, player, name, iconPath, points, board);
    hasMoved = false;
  }

  //checks if the bishop is making a valid move
  @Override
  public boolean isValidMove(int pressRank, int pressFile){
    
    //distance between file and rank of the movement
    int diffFile = Math.abs(pressFile - file);
    int diffRank = Math.abs(pressRank - rank);

    //creating a tile representing the one being pressed
    Tile pressTile = b.getTile(pressRank, pressFile);

    //checking if the king is trying to capture a king
    if(pressTile.p instanceof King){
      return false;
    }
    
    //checks if the king is only moving one space
    if (diffFile == 0 && diffRank == 1 || diffFile == 1 && diffRank == 0 || diffFile == 1 && diffRank == 1){
      //updates variable that states king has moved
      hasMoved = true;
      return true;
    }
    return false; 
  }
}
