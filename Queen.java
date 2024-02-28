public class Queen extends Piece {

  Board b;

  public Queen(int rank, int file, Player p, String icon, Board b) {
    super(rank, file, p, icon, b);
    this.b = b;
    tile = b.getTile(rank, file);
  }

  @Override
  public boolean isValidMove(int r, int f) {
    Tile pressTile = b.getTile(r, f);
    if (rank == pressTile.rank || file == pressTile.file) {

      // if in a same file
      if (rank == pressTile.rank) {
        // vertical movement
        int dy = (file < pressTile.file) ? 1 : -1;
        for (int i = file + dy; i != pressTile.file; i += dy) {
          if (b.getTile(rank, i).p != null) {
            return false;
          }
        }
      }

      // if in a same rank
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

    if (pressTile.file != this.file && pressTile.rank != this.rank){
      if(Math.abs((pressTile.file-file)/(pressTile.rank-rank)) == 1){
        int m = (pressTile.file-file) / (pressTile.rank - rank);  
        int offSet = this.file - (m * this.rank);
        //if a piece is in left
        if (pressTile.rank < rank ){

          for(int x=pressTile.rank+1;x < rank; x++){
            int y = (m*x) + offSet;
            if (b.getTile(x,y).getPiece() != null){
              return false;
            }

        }
        }
        //if a piece is in right
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