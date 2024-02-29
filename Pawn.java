public class Pawn extends Piece {

  Board b;
   
  public Pawn(int rank, int file, Player p, String name, String icon, int points, Board b) {
    super(rank, file, p, name, icon, points, b);
    this.b = b;
    tile =  b.getTile(rank, file);
  }
    
  @Override
  public boolean isValidMove(int r, int f) {
    if(player.getPlayerColor().toLowerCase().equals("white")){
      //intitial move => check if a move in front is null  
      if (file == 6) {
          if (b.getTile(r, f).file == this.tile.file - 2 && b.getTile(r, f).rank == this.tile.rank) {
            if(b.getTile(r, f).p == null){
              return true;
            }
          }
      }
      if (b.getTile(r, f).file == this.tile.file - 1 && b.getTile(r, f).rank == this.tile.rank) {
        if(b.getTile(r, f).p == null){
          return true;
        }
      }
      //checking if a white pawn can capture a piece
      else if((b.getTile(r, f).file == this.tile.file - 1 && (b.getTile(r, f).rank == this.tile.rank + 1 || b.getTile(r, f).rank == this.tile.rank - 1)) && (b.getTile(r, f).p != null && b.getTile(r, f).p.player.getPlayerColor().toLowerCase().equals("black"))){
        return true;
      }
    }  
    else{
      //intitial move => check if a move in front is null  
      if (file == 1) {
        if (b.getTile(r, f).file == this.tile.file + 2 && b.getTile(r, f).rank == this.tile.rank) {
          if(b.getTile(r, f).p == null){
            return true;
          }
        }
      }
      if (b.getTile(r, f).file == this.tile.file + 1 && b.getTile(r, f).rank == this.tile.rank) {
        if(b.getTile(r, f).p == null){
          return true;
        }
      }
      //checking if a black pawn can capture a piece
      else if((b.getTile(r, f).file == this.tile.file - 1 && (b.getTile(r, f).rank == this.tile.rank + 1 || b.getTile(r, f).rank == this.tile.rank - 1)) && (b.getTile(r, f).p != null && b.getTile(r, f).p.player.getPlayerColor().toLowerCase().equals("white"))){
        return true;
      }
    }
    return false;
  }
}
