import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessPanel extends JPanel {
    
    Board b;

    // ChessPanel cp = new ChessPanel();
    public ChessPanel() {
        super.setBounds(0, 0, 400, 400);
        super.setBackground(Color.GRAY);
        this.b = new Board();
    }
    
    //ChessPanel cp= new ChessPanel(Board);
    public ChessPanel(Board b) {
        super.setBounds(0, 0, 400, 400);
        super.setBackground(Color.GRAY);
        this.b = b;
    }

    //ChessPanel cp = new ChessPanel(BorderLayout)
    public ChessPanel(BorderLayout borderLayout) {
        super(borderLayout);
        super.setBounds(0, 0, 400, 400);
        super.setBackground(Color.GRAY);
        this.b = new Board();
    }
    
    //returns  board class
    public Board getBoard(){
        return this.b;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.draw(g);
    }
}
