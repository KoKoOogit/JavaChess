

public class Main {
    public static void main(String[] args) {
       
        ChessPanel cp = new ChessPanel();
        ChessFrame cf = new ChessFrame(800);
        Player one = new Player();
        Piece p = new Pawn(0, 0, one, "./icons/w-pawn.png", cp.getBoard());
        cp.getBoard().getTile(0, 0).setPiece(p);
        //this code should be at the end

        cf.setVisible(true);
        cf.add(cp);
        cf.setResizable(true);

    }
}