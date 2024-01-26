

public class Main {
    public static void main(String[] args) {
       
        ChessPanel cp = new ChessPanel();
        ChessFrame cf = new ChessFrame(600);
        System.out.println(cp.getBoard().getTiles());
        //this code should be at the end


        cf.setVisible(true);
        cf.add(cp);
        cf.setResizable(true);

    }
}