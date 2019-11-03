package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.GameState;
import np.com.madanpokharel.game.Position;

public class Player extends GameCharacter {
    private String name;
    private long score;

    public Player(String name) {
        super(100, 5, Position.INITIAL);
        this.name = name;
    }

    public Player(GameState gameState) {
        super(100, 5, Position.INITIAL);

        GameState newState = gameState.resetStateIfHealthIsZero();

        this.name = newState.getName();
        this.score = newState.getScore();
        this.health = newState.getHealth();
    }

    public void increaseScore() {
        this.score = score + 10;
    }

    @Override
    public String getDisplayCharacter() {
        return "\u001B[32m" + new String(Character.toChars(0x1F62E)) + "\u001B[0m";
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score;
    }
}
