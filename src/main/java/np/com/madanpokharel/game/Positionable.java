package np.com.madanpokharel.game;


public interface Positionable {
    String getDisplayCharacter();

    void updatePosition(Position position);

    Position getPosition();
}
