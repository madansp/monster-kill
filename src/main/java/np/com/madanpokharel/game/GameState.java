package np.com.madanpokharel.game;

import java.io.Serializable;

public class GameState implements Serializable {
    private String name;
    private int health;
    private long score;

    private GameState(String name, int health, long score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }
    public static GameState createState(String name,int health, long score){
        return new GameState(name,health,score);
    }

    public GameState resetStateIfHealthIsZero(){
        int health = this.health;
        long score = this.score;
        String name = this.name;
        if (health ==0){
            score=0;
        }
        return new GameState(name,health,score);
    }

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }


    public long getScore() {
        return score;
    }

}
