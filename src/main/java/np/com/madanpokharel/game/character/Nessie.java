package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.AutoMoveable;
import np.com.madanpokharel.game.MovementType;
import np.com.madanpokharel.game.Position;

public class Nessie extends GameCharacter implements AutoMoveable {

    public Nessie(Position position) {
        super(30,2,position);
    }

    @Override
   public String getDisplayCharacter() {
        return "\u001B[34m"+new String(Character.toChars(0x264F))+"\u001B[0m";
    }


    @Override
    public MovementType getMovementType() {
        return MovementType.RIGHT;
    }

}
