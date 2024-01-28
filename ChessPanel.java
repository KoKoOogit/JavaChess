import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ChessPanel extends JPanel implements MouseListener {

    Tile inSelectionTile;
    
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
    
    private Tile getPressedTile(int mouseX, int mouseY) {
        int rank = mouseX / b.tileDimension;
        int file = mouseY / b.tileDimension;
        System.out.println("X: " + rank + "Y: " +  file);
        return b.getTile(rank, file);
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

        //set the variable to pressTile if a user press on his pieces'
        if (pressedTile.getPiece() != null) {
          
            inSelectionTile = pressedTile;

        }
        //if a user press on a unoccupied tile, it will check if the moved is valid and if so it will move there
        else {
            
            if (inSelectionTile != null) {
                if (inSelectionTile.getPiece().isValidMove(pressedTile.rank, pressedTile.file)) {

                    pressedTile.setPiece(inSelectionTile.getPiece());
                    pressedTile.p.updateTile(pressedTile);
                    pressedTile.p.rank = pressedTile.rank;
                    pressedTile.p.file = pressedTile.file;

                    updateGraphics();
                    
                    inSelectionTile.removePiece();
                    inSelectionTile = null;
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
}
