import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

import java.util.Scanner;

public class ChessPanel extends JPanel implements MouseListener, WindowListener {
  
  Tile fromTile;

  Board b;

  public ChessPanel() {
    super.setBounds(0, 0, 400, 400);
    super.setBackground(Color.GRAY);
    this.b = new Board();
    addMouseListener(this);
  }

  public ChessPanel(Board b) {
    super.setBounds(0, 0, 400, 400);
    super.setBackground(Color.GRAY);
    this.b = b;
    addMouseListener(this);
  }

  public ChessPanel(BorderLayout borderLayout) {
    super(borderLayout);
    super.setBounds(0, 0, 400, 400);
    super.setBackground(Color.GRAY);
    this.b = new Board();
    addMouseListener(this);
  }

  // returns board class
  public Board getBoard() {
    return this.b;
  }

  // refresh the board
  public void updateGraphics() {
    this.repaint();
  }

  private String convertRank(int rank) {
    String rankLetter = "";
    if (rank == 0) {
      rankLetter = "a";
    } else if (rank == 1) {
      rankLetter = "b";
    } else if (rank == 2) {
      rankLetter = "c";
    } else if (rank == 3) {
      rankLetter = "d";
    } else if (rank == 4) {
      rankLetter = "e";
    } else if (rank == 5) {
      rankLetter = "f";
    } else if (rank == 6) {
      rankLetter = "g";
    } else if (rank == 7) {
      rankLetter = "h";
    }
    return rankLetter;
  }

  private Tile getPressedTile(int mouseX, int mouseY) {
    int rank = mouseX / b.tileDimension;
    int file = mouseY / b.tileDimension;
    return b.getTile(rank, file);
  }

  private void makeUpdate(Tile pressedTile) {

    if (fromTile != null) {
      if (fromTile.p.player == b.current_player) {
        if (fromTile.getPiece().isValidMove(pressedTile.rank, pressedTile.file)) {
          System.out.println(fromTile.p.player.getPlayerColor() + " " + fromTile.p.name + " moved from " + convertRank(fromTile.p.rank) + (8 - fromTile.p.file) + " to " + convertRank(pressedTile.rank) + (8 - pressedTile.file));
          if (pressedTile.p != null) {
            if (pressedTile.p.player != fromTile.p.player) {
              System.out.println(pressedTile.p.player.getPlayerColor() + " " + pressedTile.p.name + " captured by " + fromTile.p.player.getPlayerColor() + " " + fromTile.p.name);
              b.current_player.setScore(b.current_player.getScore() + pressedTile.p.points);
              pressedTile.removePiece();
            }
          }

          pressedTile.setPiece(fromTile.getPiece());
          pressedTile.p.updateTile(pressedTile);
          pressedTile.p.rank = pressedTile.rank;
          pressedTile.p.file = pressedTile.file;
          
          updateGraphics();

          if(fromTile.p instanceof Pawn && ((Pawn)fromTile.p).checkCanPromote(pressedTile.file)){
            Scanner promoteInput = new Scanner(System.in);
            System.out.println(fromTile.p.player.getPlayerColor() + "'s pawn at " + convertRank(pressedTile.rank) + (8 - pressedTile.file) + " can promote");
            System.out.println("Choose which piece to promote it too from the options below");
            System.out.println("(B) Bishop");
            System.out.println("(N) Knight");
            System.out.println("(R) Rook");
            System.out.println("(Q) Queen");
            
            while(true){
              
              String pieceInput = promoteInput.nextLine();
              
              if(pieceInput.toLowerCase().equals("b")){
                if(b.current_player.getPlayerColor().equals("White")){
                  Bishop promotedWb = new Bishop(pressedTile.rank, pressedTile.file, Main.getWhite(), "Bishop", "./icons/w-bishop.png", 3, Main.getCPBoard());
                  pressedTile.setPiece(promotedWb);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
                else{
                  Bishop promotedBb = new Bishop(pressedTile.rank, pressedTile.file, Main.getBlack(), "Bishop", "./icons/b-bishop.png", 3, Main.getCPBoard());
                  pressedTile.setPiece(promotedBb);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
              }
              
              else if(pieceInput.toLowerCase().equals("n")){
                if(b.current_player.getPlayerColor().equals("White")){
                  Knight promotedWn = new Knight(pressedTile.rank, pressedTile.file, Main.getWhite(), "Knight", "./icons/w-knight.png", 3, Main.getCPBoard());
                  pressedTile.setPiece(promotedWn);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
                else{
                  Knight promotedBn = new Knight(pressedTile.rank, pressedTile.file, Main.getBlack(), "Knight", "./icons/b-knight.png", 3, Main.getCPBoard());
                  pressedTile.setPiece(promotedBn);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
              }
              
              else if(pieceInput.toLowerCase().equals("r")){
                if(b.current_player.getPlayerColor().equals("White")){
                  Rook promotedWr = new Rook(pressedTile.rank, pressedTile.file, Main.getWhite(), "Rook", "./icons/w-rook.png", 5, Main.getCPBoard());
                  pressedTile.setPiece(promotedWr);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
                else{
                  Rook promotedBr = new Rook(pressedTile.rank, pressedTile.file, Main.getBlack(), "Rook", "./icons/b-rook.png", 5, Main.getCPBoard());
                  pressedTile.setPiece(promotedBr);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
              }
              
              else if(pieceInput.toLowerCase().equals("q")){
                if(b.current_player.getPlayerColor().equals("White")){
                  Queen promotedWq = new Queen(pressedTile.rank, pressedTile.file, Main.getWhite(), "Queen", "./icons/w-queen.png", 9, Main.getCPBoard());
                  pressedTile.setPiece(promotedWq);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
                else{
                  Queen promotedBq = new Queen(pressedTile.rank, pressedTile.file, Main.getBlack(), "Queen", "./icons/b-queen.png", 9, Main.getCPBoard());
                  pressedTile.setPiece(promotedBq);
                  pressedTile.p.updateTile(pressedTile);
                  break;
                }
              }
              
              else{
                System.out.println("Please enter a valid piece the pawn can promote to");
                System.out.println("(B) Bishop");
                System.out.println("(N) Knight");
                System.out.println("(R) Rook");
                System.out.println("(Q) Queen");
              }
            }
          }

          fromTile.removePiece();
          fromTile = null;

          //Checking
          for(int r = 0; r < 8; r++){
            for(int f = 0; f < 8; f++){
              if(b.getTile(r, f).p != null && b.getTile(r, f).p.player.getPlayerColor().equals("black") && b.getTile(r, f).p.isValidMove(Main.getWhiteKing().file, Main.getWhiteKing().rank)){
                System.out.println("The White King has been checked");
              }
              else if(b.getTile(r, f).p != null && b.getTile(r, f).p.player.getPlayerColor().equals("white") && b.getTile(r, f).p.isValidMove(Main.getBlackKing().file, Main.getBlackKing().rank)){
                System.out.println("The Black King has been checked");
              }
            }
          }

          b.switchPlayer();
          System.out.println("It's " + b.current_player.getPlayerColor() + "'s turn");
          System.out.println("");
        }
      } 
    }
  }
  
  // called when Jpanel initiated or updateGrahics
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    b.draw(g);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // Called when a mouse button is pressed
    Tile pressedTile = getPressedTile(e.getX(), e.getY());

    // if a userpressedTile has a piece, fromTile will set to that piece unless
    // pressedTile's piece is not player's
    if (pressedTile.getPiece() != null) {
      // check if it is a player's turn

      if (fromTile == null) {
        if (pressedTile.p.player == b.current_player) {
          fromTile = pressedTile;
        }
      } else {
        if (fromTile.p.player != pressedTile.p.player) {
          if (fromTile.p.player == b.current_player) {
            makeUpdate(pressedTile);
          }
        } else {
          if (fromTile.p.player == b.current_player) {
            fromTile = pressedTile;
          }
        }
      }

    }
    
    // if a user press on a unoccupied tile, it will check if the move is valid and
    // if so it will move there
    else {
      if (fromTile != null)
      {
        if (fromTile.p.player == b.current_player) {
          makeUpdate(pressedTile);
        }
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // Called when a mouse button is released
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // Called when the mouse enters the component
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // Called when the mouse exits the component
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    
  }

  @Override
    public void windowOpened(WindowEvent e){
      
    }

    @Override
    public void windowClosing(WindowEvent e){

    }

    @Override
    public void windowClosed(WindowEvent e){
      
    }

    @Override
    public void windowIconified(WindowEvent e){
      
    }

    @Override
    public void windowDeiconified(WindowEvent e){
      
    }

    @Override
    public void windowActivated(WindowEvent e){
      
    }

    @Override
    public void windowDeactivated(WindowEvent e){
      
    }
  
}
