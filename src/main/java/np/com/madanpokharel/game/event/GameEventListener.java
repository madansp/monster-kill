package np.com.madanpokharel.game.event;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.Position;

public interface GameEventListener {
    void enemyFound(GameCharacter character);
    void playerMoved(Position position);
    void screenUpdated();
    void gameExited();

}
