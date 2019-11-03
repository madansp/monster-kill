package np.com.madanpokharel.game.event;

public interface GameEndEventListener {
    void gameEnded(EndType endType);

    enum EndType{
        WIN,LOOSE
    }
}
