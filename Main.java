import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    ChessPanel cp = new ChessPanel();
    ChessFrame cf = new ChessFrame(800);
    
    Player white = new Player("white");
    Player black = new Player("black");
    
    ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    ArrayList<Piece> blackPieces = new ArrayList<Piece>();

    Piece Wp1 = new Pawn(0, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp2 = new Pawn(1, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp3 = new Pawn(2, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp4 = new Pawn(3, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp5 = new Pawn(4, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp6 = new Pawn(5, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp7 = new Pawn(6, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wp8 = new Pawn(7, 6, white, "./icons/w-pawn.png", cp.getBoard());
    Piece Wr1 = new Rook(0, 7, white, "./icons/w-rook.png", cp.getBoard());
    Piece Wn1 = new Knight(1, 7, white, "./icons/w-knight.png", cp.getBoard());
    Piece Wb1 = new Bishop(2, 7, white,"./icons/w-bishop.png",cp.getBoard());
    Piece Wq = new Queen(3, 7, white, "./icons/w-queen.png", cp.getBoard());
    Piece Wk = new King(4, 7, white, "./icons/w-king.png", cp.getBoard());
    Piece Wb2 = new Bishop(5, 7, white,"./icons/w-bishop.png",cp.getBoard());
    Piece Wn2 = new Knight(6, 7, white, "./icons/w-knight.png", cp.getBoard());
    Piece Wr2 = new Rook(7, 7, white, "./icons/w-rook.png", cp.getBoard());

    Piece Bp1 = new Pawn(0, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp2 = new Pawn(1, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp3 = new Pawn(2, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp4 = new Pawn(3, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp5 = new Pawn(4, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp6 = new Pawn(5, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp7 = new Pawn(6, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Bp8 = new Pawn(7, 1, black, "./icons/b-pawn.png", cp.getBoard());
    Piece Br1 = new Rook(0, 0, black, "./icons/b-rook.png", cp.getBoard());
    Piece Bn1 = new Knight(1, 0, black, "./icons/b-knight.png", cp.getBoard());
    Piece Bb1 = new Bishop(2, 0, black,"./icons/b-bishop.png",cp.getBoard());
    Piece Bq = new Queen(3, 0, black, "./icons/b-queen.png", cp.getBoard());
    Piece Bk = new King(4, 0, black, "./icons/b-king.png", cp.getBoard());
    Piece Bb2 = new Bishop(5, 0, black,"./icons/b-bishop.png",cp.getBoard());
    Piece Bn2 = new Knight(6, 0, black, "./icons/b-knight.png", cp.getBoard());
    Piece Br2 = new Rook(7, 0, black, "./icons/b-rook.png", cp.getBoard());
    
    cp.getBoard().getTile(0, 6).setPiece(Wp1);
    cp.getBoard().getTile(1, 6).setPiece(Wp2);
    cp.getBoard().getTile(2, 6).setPiece(Wp3);
    cp.getBoard().getTile(3, 6).setPiece(Wp4);
    cp.getBoard().getTile(4, 6).setPiece(Wp5);
    cp.getBoard().getTile(5, 6).setPiece(Wp6);
    cp.getBoard().getTile(6, 6).setPiece(Wp7);
    cp.getBoard().getTile(7, 6).setPiece(Wp8);
    cp.getBoard().getTile(0, 7).setPiece(Wr1);
    cp.getBoard().getTile(1, 7).setPiece(Wn1);
    cp.getBoard().getTile(2, 7).setPiece(Wb1);
    cp.getBoard().getTile(3, 7).setPiece(Wq);
    cp.getBoard().getTile(4, 7).setPiece(Wk);
    cp.getBoard().getTile(5, 7).setPiece(Wb2);
    cp.getBoard().getTile(6, 7).setPiece(Wn2);
    cp.getBoard().getTile(7, 7).setPiece(Wr2);

    cp.getBoard().getTile(0, 1).setPiece(Bp1);
    cp.getBoard().getTile(1, 1).setPiece(Bp2);
    cp.getBoard().getTile(2, 1).setPiece(Bp3);
    cp.getBoard().getTile(3, 1).setPiece(Bp4);
    cp.getBoard().getTile(4, 1).setPiece(Bp5);
    cp.getBoard().getTile(5, 1).setPiece(Bp6);
    cp.getBoard().getTile(6, 1).setPiece(Bp7);
    cp.getBoard().getTile(7, 1).setPiece(Bp8);
    cp.getBoard().getTile(0, 0).setPiece(Br1);
    cp.getBoard().getTile(1, 0).setPiece(Bn1);
    cp.getBoard().getTile(2, 0).setPiece(Bb1);
    cp.getBoard().getTile(3, 0).setPiece(Bq);
    cp.getBoard().getTile(4, 0).setPiece(Bk);
    cp.getBoard().getTile(5, 0).setPiece(Bb2);
    cp.getBoard().getTile(6, 0).setPiece(Bn2);
    cp.getBoard().getTile(7, 0).setPiece(Br2);
   
    // this code should be at the end
    cf.setVisible(true);
    cf.add(cp);
    cf.setResizable(true);

    System.out.println("Chess Game");
    System.out.println("(1) ");
  }
}