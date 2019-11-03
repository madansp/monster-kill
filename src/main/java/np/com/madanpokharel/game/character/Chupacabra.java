package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.AutoMoveable;
import np.com.madanpokharel.game.MovementType;
import np.com.madanpokharel.game.Position;

public class Chupacabra extends GameCharacter  implements AutoMoveable {

    public Chupacabra(Position position) {
        super(20,1,position);
    }

    @Override
    public String getDisplayCharacter() {
        return   "\u001B[31m".concat(new String(Character.toChars(0x264D))).concat("\u001B[0m");
    }


    @Override
    public MovementType getMovementType() {
        return MovementType.DOWN;
    }


}
