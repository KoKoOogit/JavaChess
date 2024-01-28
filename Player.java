import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Piece> capPieces = new ArrayList<Piece>();
    private ArrayList<Piece> lossPieces = new ArrayList<Piece>();
    
    public void addCapPiece(Piece p) {
        this.capPieces.add(p);
    }

    public ArrayList<Piece> getCapPieces() {
        return this.capPieces;
    }


}

