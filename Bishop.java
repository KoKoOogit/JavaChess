import java.lang.Math;

public class Bishop extends Piece {

public Bishop(int rank, int file, Player p, String icon, Board b) {
  super(rank, file, p, icon, b);
  this.b = b;
  tile = b.getTile(rank, file);
}

  @Override
  public boolean isValidMove(int r,int f) {
   
    Tile pressTile = b.getTile(r,f);


    //if same slope ==> 1 valid move
    //condition below prevents divisible by zero Error
    if (pressTile.file != this.file && pressTile.rank != this.rank){
      if(Math.abs((pressTile.file-file)/(pressTile.rank-rank)) == 1){
        int m = (pressTile.file-file) / (pressTile.rank - rank);  
        int offSet = this.file - (m * this.rank);
        //if a piece is in left
        if (pressTile.rank < rank ){
          for(int x=pressTile.rank;x < rank; x++){
            int y = (m*x) + offSet;
            if (b.getTile(x,y).getPiece() != null){
              return false;
            }
          }
        }
        //if a piece is in right
        if (pressTile.rank > rank ) {
          for (int x =pressTile.rank; x > rank; x--){
            int y = (m*x) + offSet;
            if (b.getTile(x,y).getPiece() != null){
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
    return false;
    
    
  }
}