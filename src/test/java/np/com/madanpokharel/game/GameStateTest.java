package np.com.madanpokharel.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void givenZeroHealth_whenReset_thenShouldResetScoreToZero() {
        GameState gameState = GameState.createState("test",0,100);
        assertEquals(gameState.getScore(),100);
        GameState newState = gameState.resetStateIfHealthIsZero();
        assertEquals(newState.getScore(),0);
    }

    @Test
    public void givenNoZeroHealth_whenReset_thenShouldNotResetScoreToZero() {
        GameState gameState = GameState.createState("test",20,100);
        assertEquals(gameState.getScore(),100);
        GameState newState = gameState.resetStateIfHealthIsZero();
        assertEquals(newState.getScore(),100);
    }
}