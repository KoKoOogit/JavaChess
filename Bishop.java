import java.lang.Math;

public class Bishop extends Piece {

  //constructor for bishop that assigns attributes
  public Bishop(int rank, int file, Player p, String name, String icon, int points, Board b){
  super(rank, file, p, name, icon, points, b);
  this.b = b;
  tile = b.getTile(rank, file);
}

  //checks if the bishop is making a valid move
  @Override
  public boolean isValidMove(int r,int f){
   
    //creating a tile representing the one being pressed
    Tile pressTile = b.getTile(r,f);

    //checking if the bishop is trying to capture a king
    if(pressTile.p instanceof King){
      return false;
    }

    //condition below prevents divisible by zero error
    if (pressTile.file != this.file && pressTile.rank != this.rank){
      if(Math.abs((pressTile.file-file)/(pressTile.rank-rank)) == 1){
        //if the bishop's movement has a slope of 1, it is a valid move
        int m = (pressTile.file-file) / (pressTile.rank - rank);  
        int offSet = this.file - (m * this.rank);
        //if the bishop moves to the left
        if (pressTile.rank < rank ){
          //traversing the path of the bishop
          for(int x = pressTile.rank + 1; x < rank; x++){
            int y = (m*x) + offSet;
            //checking if there are pieces blocking movement of the bishop
            if (b.getTile(x,y).getPiece() != null){
              return false;
            }
          }
        }
        
        //if the bishop moves to the right
        if (pressTile.rank > rank ) {
          //traversing the path of the bishop
          for (int x =pressTile.rank-1; x > rank; x--){
            int y = (m*x) + offSet;
            //checking if there are pieces blocking movement of the bishop
            if (b.getTile(x, y).getPiece() != null) {
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