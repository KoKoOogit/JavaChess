import java.awt.Color;

import javax.swing.*;

public class ChessFrame extends JFrame {

    //default constructor
    public ChessFrame() {
       
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 500);

        super.setTitle("Chess Game");
        super.getContentPane().setBackground(Color.GRAY);

    }
    //constructor with dimension
    public ChessFrame(int d) {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(d, d);
       
        super.setTitle("Chess Game");
        super.getContentPane().setBackground(Color.GRAY);

    }
}
