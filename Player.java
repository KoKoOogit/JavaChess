import java.util.ArrayList;

public class Player {
  private String color;
  private int score;

  //Constructor for player that assigns attributes
  public Player(String color, int score){
    this.color = color;
    this.score = score;
  }

  public String getPlayerColor(){
    return this.color;
  }

  public int getScore(){
    return score;
  }

  public void setScore(int score){
    this.score = score;
  }
}

