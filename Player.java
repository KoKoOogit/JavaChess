import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Piece> capturedPieces = new ArrayList<Piece>();
    private ArrayList<Piece> lostPieces = new ArrayList<Piece>();
    
    public void addCapturedPiece(Piece p) {
        this.capturedPieces.add(p);
    }

    public ArrayList<Piece> getCapturedPieces() {
        return this.capturedPieces;
    }


}

