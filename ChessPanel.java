import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ChessPanel extends JPanel implements MouseListener {

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

    //ChessPanel cp = new ChessPanel(BorderLayout)
    public ChessPanel(BorderLayout borderLayout) {
        super(borderLayout);
        super.setBounds(0, 0, 400, 400);
        super.setBackground(Color.GRAY);
        this.b = new Board();
        addMouseListener(this);
    }

    //returns  board class
    public Board getBoard() {
        return this.b;
    }

    //refresh the board
    public void updateGraphics() {
        this.repaint();
    }

    private String convertRank(int rank){
      String rankLetter = "";
      if(rank == 0){
        rankLetter = "a";
      }
      else if(rank == 1){
        rankLetter = "b";
      }
      else if(rank == 2){
        rankLetter = "c";
      }
      else if(rank == 3){
        rankLetter = "d";
      }
      else if(rank == 4){
        rankLetter = "e";
      }
      else if(rank == 5){
        rankLetter = "f";
      }
      else if(rank == 6){
        rankLetter = "g";
      }
      else if(rank == 7){
        rankLetter = "h";
      }
      return rankLetter;
    }
  
    private Tile getPressedTile(int mouseX, int mouseY) {
      int rank = mouseX / b.tileDimension;
      int file = mouseY / b.tileDimension;
      return b.getTile(rank, file);
    }

  private void makeUpdate(Tile pressedTile){
    if (fromTile != null) {
        if (fromTile.getPiece().isValidMove(pressedTile.rank, pressedTile.file)) {
          System.out.println(fromTile.p.player.getPlayerColor() + " " + fromTile.p.name + " moved from " + convertRank(fromTile.p.rank) + (8 - fromTile.p.file) + " to " + convertRank(pressedTile.rank) + (8 - pressedTile.file));
          if (pressedTile.p != null){
            if (pressedTile.p.player != fromTile.p.player){
              if(!pressedTile.p.name.equals("King")){
                System.out.println(pressedTile.p.player.getPlayerColor() + " " + pressedTile.p.name + " captured by " + fromTile.p.player.getPlayerColor() + " " + fromTile.p.name);
                pressedTile.removePiece();
              } 
            }
          }

          pressedTile.setPiece(fromTile.getPiece());
          pressedTile.p.updateTile(pressedTile);
          pressedTile.p.rank = pressedTile.rank;
          pressedTile.p.file = pressedTile.file;

          updateGraphics();

          fromTile.removePiece();
          fromTile = null;
        }
      }   
    }
  
    //called when Jpanel initiated or updateGrahics
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.draw(g);
    }

    @Override
  public void mousePressed(MouseEvent e) {
    // Called when a mouse button is pressed
    Tile pressedTile = getPressedTile(e.getX(), e.getY());

    //if a userpressedTile has a piece, fromTile will set to that piece unless pressedTile's piece is not player's
    if (pressedTile.getPiece() != null ) {
      if (fromTile == null ){
        fromTile = pressedTile;
        }
      else{
        if (fromTile.p.player != pressedTile.p.player)
        {    
        makeUpdate(pressedTile);
      }
        else{
          fromTile = pressedTile;
        }
      }
    }
    //if a user press on a unoccupied tile, it will check if the move is valid and if so it will move there
    else {
      makeUpdate(pressedTile);
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
}
