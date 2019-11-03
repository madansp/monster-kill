package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.MovementType;
import np.com.madanpokharel.game.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class NessieTest {

    @Test
    public void testDisplayCharacter() {
        Nessie nessie= new Nessie(Position.INITIAL);
        assertEquals("\u001B[34m"+new String(Character.toChars(0x264F))+"\u001B[0m",
                nessie.getDisplayCharacter());
    }

    @Test
    public void testMovementType() {
        Nessie nessie= new Nessie(Position.INITIAL);
        assertEquals(MovementType.RIGHT, nessie.getMovementType());
    }

}