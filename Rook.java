public class Rook extends Piece {

  Board b;

  public Rook(int rank, int file, Player p, String icon, Board b) {
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

        // if pressTile is above piece
        if (pressTile.file < file) {
          for (int i = pressTile.file + 2; i < file; i++) {
            if (b.getTile(rank, i).p != null) {
              return false;
            }
          }
        }

        // if pressTile is below piece
        if (pressTile.file > file) {
          for (int i = pressTile.file; i > file; i--) {
            if (b.getTile(rank, i).p != null) {
              return false;
            }
          }
        }
        return true;
      }

      // if in a same rank
      if (file == pressTile.file) {
        // if pressTile is at left
        if (pressTile.rank < rank) {
          for (int i = pressTile.rank; i < rank; i++) {
            if (b.getTile(i, file).p != null) {
              return false;
            }
          }
        }
        //if pressTile is at right
        if (pressTile.rank > rank){
          for(int i= pressTile.rank; i>rank; i--){
            if(b.getTile(i,file).p != null){
              return false;
            }
          }
        }

        return true;
      }
    }
    return false;
  }
}