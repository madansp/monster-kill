package np.com.madanpokharel.game;

public interface AutoMoveable extends Positionable {
    MovementType getMovementType();
    Position getPosition();

    default Position move(){
        return getPosition().move(getMovementType());
    }
}
