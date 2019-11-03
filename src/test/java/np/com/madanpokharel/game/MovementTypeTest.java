package np.com.madanpokharel.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovementTypeTest {

    @Test
    public void givenNullValue_whenValueFrom_thenReturnNO_MOVEMENT() {
        MovementType movementType = MovementType.valueFrom("");
        assertEquals(MovementType.NO_MOVEMENT,movementType);
    }

    @Test
    public void givenU_whenValueFrom_thenReturnUP() {
        MovementType movementType = MovementType.valueFrom("U");
        assertEquals(MovementType.UP,movementType);
    }

    @Test
    public void givenD_whenValueFrom_thenReturnDOWN() {
        MovementType movementType = MovementType.valueFrom("D");
        assertEquals(MovementType.DOWN,movementType);
    }

    @Test
    public void givenR_whenValueFrom_thenReturnRIGHT() {
        MovementType movementType = MovementType.valueFrom("R");
        assertEquals(MovementType.RIGHT,movementType);
    }

    @Test
    public void givenL_whenValueFrom_thenReturnLEFT() {
        MovementType movementType = MovementType.valueFrom("L");
        assertEquals(MovementType.LEFT,movementType);
    }
    @Test
    public void givenUnknown_whenValueFrom_thenReturnNO_MOVEMENT() {
        MovementType movementType = MovementType.valueFrom("TEST");
        assertEquals(MovementType.NO_MOVEMENT,movementType);
    }

}