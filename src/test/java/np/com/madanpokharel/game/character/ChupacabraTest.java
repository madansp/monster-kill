package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.MovementType;
import np.com.madanpokharel.game.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChupacabraTest {

    @Test
    public void testDisplayCharacter() {
        Chupacabra chupacabra= new Chupacabra(Position.INITIAL);
        assertEquals("\u001B[31m".concat(new String(Character.toChars(0x264D))).concat("\u001B[0m"),
                chupacabra.getDisplayCharacter());
    }

    @Test
    public void testMovementType() {
        Chupacabra chupacabra= new Chupacabra(Position.INITIAL);
        assertEquals(MovementType.DOWN, chupacabra.getMovementType());
    }
}