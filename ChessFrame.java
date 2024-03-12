import java.awt.Color;
import java.awt.event.WindowAdapter;

import javax.swing.*;

public class ChessFrame extends JFrame {

    //Constructor for frame that assigns attributes
    public ChessFrame(int width, int length) {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(width, length);
       
        super.setTitle("Chess");
        super.getContentPane().setBackground(Color.GRAY);

    }
}
