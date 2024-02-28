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
        //vertical movement
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
    return false;
  }
}