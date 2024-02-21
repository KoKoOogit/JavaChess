public class Pawn extends Piece {

  Board b;
   
  public Pawn(int rank, int file, Player p, String icon, Board b) {
    super(rank, file, p, icon, b);
    this.b = b;
    tile =  b.getTile(rank, file);
  }
    
  @Override
  public boolean isValidMove(int r, int f) {
    if(player.getPlayerColor().equals("white")){
      //intitial move => check if a move in front is null  
      if (file == 6) {
          if (b.getTile(r, f).file == this.tile.file - 2 && b.getTile(r, f).rank == this.tile.rank) {
              return true;
          }
      }
      if (b.getTile(r, f).file == this.tile.file - 1 && b.getTile(r, f).rank == this.tile.rank) {
          return true;
      }
    }  
    else{
      //intitial move => check if a move in front is null  
      if (file == 1) {
          if (b.getTile(r, f).file == this.tile.file + 2 && b.getTile(r, f).rank == this.tile.rank) {
              return true;
          }
      }
      if (b.getTile(r, f).file == this.tile.file + 1 && b.getTile(r, f).rank == this.tile.rank) {
          return true;
      }
    }
    return false;
  }
}
