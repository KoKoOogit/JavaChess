public class Rook extends Piece {

  Board b;
  private boolean hasMoved;

  //Constructor for rook that assigns attributes
  public Rook(int rank, int file, Player p, String name, String icon, int points, Board b) {
    super(rank, file, p, name, icon, points, b);
    this.b = b;
    this.hasMoved = false;
    tile = b.getTile(rank, file);
  }

  @Override
  public boolean isValidMove(int r, int f) {
    Tile pressTile = b.getTile(r, f);
    if(pressTile.p instanceof King){
      return false;
    }
    if (rank == pressTile.rank || file == pressTile.file){
      //if in a same rank
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
      hasMoved = true;
      return true;
    }
    return false;
  }
}