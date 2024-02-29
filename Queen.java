public class Queen extends Piece {

  Board b;

  //Constructor for queen that assigns attributes
  public Queen(int rank, int file, Player p, String name, String icon, int points, Board b) {
    super(rank, file, p, name, icon, points, b);
    this.b = b;
    tile = b.getTile(rank, file);
  }

  @Override
  public boolean isValidMove(int pressRank, int pressFile) {
    Tile pressTile = b.getTile(pressRank, pressFile);
    
    if (rank == pressTile.rank || file == pressTile.file) {
      // if in a same rank
      if (rank == pressTile.rank) {
        int dy = (file < pressTile.file) ? 1 : -1;
        for (int i = file + dy; i != pressTile.file; i += dy) {
          if (b.getTile(rank, i).p != null) {
            return false;
          }
        }
      }

      // if in a same file
      if (file == pressTile.file) {
        int dx = (rank < pressTile.rank) ? 1 : -1;
        for (int i = rank + dx; i != pressTile.rank; i += dx) {
          if (b.getTile(i, file).p != null) {
            return false;
          }
        }
      }
      return true;
    }

    
    //condition below prevents divisible by zero Error
    if(pressTile.file != this.file && pressTile.rank != this.rank){
      if(Math.abs((pressTile.file-file)/(pressTile.rank-rank)) == 1){
        //if the queen's movement has a slope of 1, it is a valid move
        int m = (pressTile.file-file) / (pressTile.rank - rank);  
        int offSet = this.file - (m * this.rank);
        
        //if the queen moves to the left
        if (pressTile.rank < rank ){
          for(int x=pressTile.rank+1;x < rank; x++){
            int y = (m*x) + offSet;
            if (b.getTile(x,y).getPiece() != null){
              return false;
            }
          }
        }
        
        //if the queen moves to the right
        if (pressTile.rank > rank ) {
          for (int x =pressTile.rank-1; x > rank; x--){
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