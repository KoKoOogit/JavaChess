//Queen does not work properly in bottom left quadrant
public class Queen extends Piece {

  Board b;

  public Queen(int rank, int file, Player p, String icon, Board b) {
    super(rank, file, p, icon, b);
    this.b = b;
    tile = b.getTile(rank, file);
  }

  @Override
  public boolean isValidMove(int r, int f){
    //intitial move => check if a move in front is null  
    Tile pressTile = b.getTile(r,f);

    //if the presstile is in same file

    if (pressTile.file == this.tile.file){
      //if the pressTile is in left 
      if(pressTile.rank < this.rank){
        for(int i =pressTile.rank ; i < this.rank; i++){
          if (b.getTile(i,this.file).p != null){
            return false;
          } 
        }
      }
      if (pressTile.rank > this.rank){
        for(int i=pressTile.rank; i > this.rank; i--){
          if(b.getTile(i,this.file).p != null){
            return false;
          }
        }
      }
      return true;
    }
    //if pressTile is in same rank 
    else if(pressTile.rank == this.tile.rank){
      //if the pressTile is above
      if (pressTile.file < this.file){
        for(int i=pressTile.file; i > this.tile.file; i++){
          if(b.getTile(pressTile.rank,i).p != null){
            System.out.print("Test jump you clicked above");
            return false;
          }
        }
      }
      if(pressTile.file > this.file){
        for(int i = pressTile.file; i < this.file; i--){
          if(b.getTile(pressTile.rank,i).p != null){
            System.out.print("Test jump you clicked below");
            return false;
          }
        }
      }
    return true;
  }
    else{
      return false; 
    }
  }
}