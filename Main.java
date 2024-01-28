

public class Main {
    public static void main(String[] args) {
       
        ChessPanel cp = new ChessPanel();
        ChessFrame cf = new ChessFrame(800);
        System.out.println(cp.getBoard().getTiles()[7][6].file);
      
        //this code should be at the end

        cf.setVisible(true);
        cf.add(cp);
        cf.setResizable(true);

    }
}