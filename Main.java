import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    //Creating the new GUI frame for the chess board
    ChessPanel cp = new ChessPanel();
    ChessFrame cf = new ChessFrame(800);

    //Creating the new players of the game
    Player white = new Player("White", 0);
    Player black = new Player("Black", 0);

    //Creating all the white pieces
    Piece Wp1 = new Pawn(0, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp2 = new Pawn(1, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp3 = new Pawn(2, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp4 = new Pawn(3, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp5 = new Pawn(4, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp6 = new Pawn(5, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp7 = new Pawn(6, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wp8 = new Pawn(7, 6, white, "Pawn", "./icons/w-pawn.png", 1, cp.getBoard());
    Piece Wr1 = new Rook(0, 7, white, "Rook", "./icons/w-rook.png", 5, cp.getBoard());
    Piece Wn1 = new Knight(1, 7, white, "Knight", "./icons/w-knight.png", 3, cp.getBoard());
    Piece Wb1 = new Bishop(2, 7, white, "Bishop", "./icons/w-bishop.png", 3, cp.getBoard());
    Piece Wq = new Queen(3, 7, white, "Queen", "./icons/w-queen.png", 9, cp.getBoard());
    Piece Wk = new King(4, 7, white, "King", "./icons/w-king.png", 0, cp.getBoard());
    Piece Wb2 = new Bishop(5, 7, white, "Bishop", "./icons/w-bishop.png", 3, cp.getBoard());
    Piece Wn2 = new Knight(6, 7, white, "Knight", "./icons/w-knight.png", 3, cp.getBoard());
    Piece Wr2 = new Rook(7, 7, white, "Rook", "./icons/w-rook.png", 5, cp.getBoard());

    //Creating all the black pieces
    Piece Bp1 = new Pawn(0, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp2 = new Pawn(1, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp3 = new Pawn(2, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp4 = new Pawn(3, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp5 = new Pawn(4, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp6 = new Pawn(5, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp7 = new Pawn(6, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Bp8 = new Pawn(7, 1, black, "Pawn", "./icons/b-pawn.png", 1, cp.getBoard());
    Piece Br1 = new Rook(0, 0, black, "Rook", "./icons/b-rook.png", 5, cp.getBoard());
    Piece Bn1 = new Knight(1, 0, black, "Knight", "./icons/b-knight.png", 3, cp.getBoard());
    Piece Bb1 = new Bishop(2, 0, black, "Bishop", "./icons/b-bishop.png", 3, cp.getBoard());
    Piece Bq = new Queen(3, 0, black, "Queen", "./icons/b-queen.png", 9, cp.getBoard());
    Piece Bk = new King(4, 0, black, "King", "./icons/b-king.png", 0, cp.getBoard());
    Piece Bb2 = new Bishop(5, 0, black, "Bishop", "./icons/b-bishop.png", 3, cp.getBoard());
    Piece Bn2 = new Knight(6, 0, black, "Knight", "./icons/b-knight.png", 3, cp.getBoard());
    Piece Br2 = new Rook(7, 0, black, "Rook", "./icons/b-rook.png", 9, cp.getBoard());

    //Setting all the locations of the white pieces
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

    //Setting all the locations of the black pieces
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
   
    //Sets attributes of the GUI
    cf.setVisible(true);
    cf.add(cp);
    cf.setResizable(false);

    Scanner chessConsole = new Scanner(System.in);

    System.out.println("\"Tour Guide\" Project");
    System.out.println("Chess is a board game for two players, referred to as white and black, each controlling an army of chess pieces, with the objective to checkmate the opponent's king. Below are some of the features of the console. Enter the corresponding numbers to access this feature at any time!");
    System.out.println("(1) Help");
    System.out.println("(2) Rules");
    System.out.println("(3) Draw/Forfeit");
    while(true){
      String input = chessConsole.nextLine();
      if(input.equals("1")){
        System.out.println("To move the pieces first click the piece you want to move, then click the square you want to move it to. If you click a tile where there is already a piece, your own piece will only move if the existing piece on the tile is a different color"); 
      }
      else if(input.equals("2")){
        System.out.println("For the rules, refer to this article by chess.com"); 
        System.out.println("https://www.chess.com/learn-how-to-play-chess");
      }
      else if(input.equals("3")){
        System.out.println("The game has been manually ended!"); 
        System.exit(0);
      }
      else{
        System.out.println("Please enter a valid input, provided below");
        System.out.println("(1) Help");
        System.out.println("(2) Rules");
        System.out.println("(3) Draw/Forfeit");
      }
    }
  }
}