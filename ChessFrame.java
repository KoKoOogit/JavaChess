import java.awt.Color;

import javax.swing.*;

public class ChessFrame extends JFrame {

    //Constructor for frame that assigns attributes
    public ChessFrame(int dimension) {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(dimension, dimension);
       
        super.setTitle("Chess");
        super.getContentPane().setBackground(Color.GRAY);

    }
}
