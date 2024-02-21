import java.lang.Math;

public class Knight extends Piece {
    
    public Knight(int r, int file, Player player, String iconPath, Board board) {
        super(r, file, player, iconPath, board);
    }
    @Override
    public boolean isValidMove(int pRank, int pFile){
        int diffFile = Math.abs(pFile - file);
        int diffRank = Math.abs(pRank - rank);

        if (diffFile == 2 && diffRank == 1 || diffFile == 1 && diffRank == 2){
          return true;
        }
        return false; 
    }
}
