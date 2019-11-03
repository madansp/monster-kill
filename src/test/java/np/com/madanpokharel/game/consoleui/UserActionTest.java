package np.com.madanpokharel.game.consoleui;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserActionTest {

    @Test
    public void ifActionIsF_whenCallIsAction_returnTrue() {
        UserAction userAction= UserAction.F;
        assertTrue(userAction.isAction());
    }
    @Test
    public void ifActionIsNotEFN_whenCallIsMomvement_returnTrue() {
        UserAction userAction= UserAction.U;
        assertTrue(userAction.isMovement());
    }
    @Test
    public void ifActionIsE_whenCallIsExit_returnTrue() {
        UserAction userAction= UserAction.E;
        assertTrue(userAction.isExit());
    }
}