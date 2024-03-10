public class Pawn extends Piece {

  Board b;
   
  public Pawn(int rank, int file, Player p, String name, String icon, int points, Board b) {
    super(rank, file, p, name, icon, points, b);
    this.b = b;
    tile =  b.getTile(rank, file);
  }
    
  @Override
  public boolean isValidMove(int r, int f) {

    Tile pressTile = b.getTile(r, f);
    
    if(pressTile.p instanceof King){
      return false;
    }
    
    if(player.getPlayerColor().toLowerCase().equals("white")){
      //intitial move => check if a move in front is null  
      if (file == 6) {
          if (pressTile.file == this.tile.file - 2 && pressTile.rank == this.tile.rank) {
            if(pressTile.p == null){
              return true;
            }
          }
      }
      if (pressTile.file == this.tile.file - 1 && pressTile.rank == this.tile.rank) {
        if(pressTile.p == null){
          return true;
        }
      }
      //checking if a white pawn can capture a piece
      else if((pressTile.file == this.tile.file - 1 && (pressTile.rank == this.tile.rank + 1 || pressTile.rank == this.tile.rank - 1)) && (pressTile.p != null && pressTile.p.player.getPlayerColor().toLowerCase().equals("black"))){
        return true;
      }
    }  
    else{
      //intitial move => check if a move in front is null  
      if (file == 1) {
        if (pressTile.file == this.tile.file + 2 && pressTile.rank == this.tile.rank) {
          if(pressTile.p == null){
            return true;
          }
        }
      }
      if (pressTile.file == this.tile.file + 1 && pressTile.rank == this.tile.rank) {
        if(pressTile.p == null){
          return true;
        }
      }
      //checking if a black pawn can capture a piece
      else if((pressTile.file == this.tile.file + 1 && (pressTile.rank == this.tile.rank - 1 || pressTile.rank == this.tile.rank + 1)) && (pressTile.p != null && pressTile.p.player.getPlayerColor().toLowerCase().equals("white"))){
        return true;
      }
    }
    return false;
  }

  public boolean checkCanPromote(int f){
    if(player.getPlayerColor().toLowerCase().equals("white")){
      if(f == 0){
        return true;
      }
    }
    else{
      if(f == 7){
        return true;
      }
    }
    return false;
  }
}
