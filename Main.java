

public class Main {
    public static void main(String[] args) {
       
        ChessPanel cp = new ChessPanel();
        ChessFrame cf = new ChessFrame(800);
        Player one = new Player();
        Piece p = new Pawn(0, 0, one, "./icons/w-pawn.png", cp.getBoard());
        Piece k = new Knight(4, 4, one, "./icons/w-knight.png", cp.getBoard());
        cp.getBoard().getTile(0, 0).setPiece(p);
        cp.getBoard().getTile(4, 4).setPiece(k);
        //this code should be at the end

        cf.setVisible(true);
        cf.add(cp);
        cf.setResizable(true);

    }
}