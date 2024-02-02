
public class Main {
  public static void main(String[] args) {

    ChessPanel cp = new ChessPanel();
    ChessFrame cf = new ChessFrame(800);
    Player one = new Player();
    Piece p = new Pawn(0, 1, one, "./icons/w-pawn.png", cp.getBoard());
    Piece k = new Knight(1, 7, one, "./icons/w-knight.png", cp.getBoard());
    Piece r = new Rook(0, 7, one, "./icons/w-rook.png", cp.getBoard());
    Piece q = new Queen(0, 4, one, "./icons/w-queen.png", cp.getBoard());
    Piece b = new Bishop(3,3,one,"./icons/w-bishop.png",cp.getBoard());
    cp.getBoard().getTile(0, 1).setPiece(p);
    cp.getBoard().getTile(1, 7).setPiece(k);
    cp.getBoard().getTile(0, 7).setPiece(r);
    cp.getBoard().getTile(0, 4).setPiece(q);
    cp.getBoard().getTile(3,3).p = b;

    // this code should be at the end
    cf.setVisible(true);
    cf.add(cp);
    cf.setResizable(true);

  }
}