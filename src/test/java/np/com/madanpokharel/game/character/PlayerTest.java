package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.GameState;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testWhenCreateSetDefaultVisibilityAndImpact() {
        Player player = new Player("test");
        assertEquals(5, player.getVisibility());
        assertEquals(100, player.getImpact());
    }

    @Test
    public void testIncreaseScore() {
        Player player = new Player("test");
        assertEquals(0, player.getScore());
        player.increaseScore();
        assertEquals(10, player.getScore());
        player.increaseScore();
        assertEquals(20, player.getScore());

    }
    @Test
    public void whenAttacked_shouldDecreaseHealth() {
        Player player = new Player("test");
        player.attacked(30);
        assertEquals(70,player.getHealth());
    }

    @Test
    public void whenAttack_shouldDecreaseHealthOfEnemy() {
        Player player = new Player("test");
        Player player1 = new Player("test1");
        player.attack(player1);

        assertEquals(0,player1.getHealth());
    }

    @Test
    public void givenHealthIsZero_whenCallIsDead_thenReturnTrue() {
        Player player = new Player("test");
        player.attacked(100);
        assertTrue(player.isDead());
    }

    @Test
    public void testCreatePlayerFromGameState() {
        GameState gameState = GameState.createState("name",100,10);
        Player player = new Player(gameState);
        assertEquals("name",player.getName());
        assertEquals(100,player.getHealth());
        assertEquals(10,player.getScore());
    }

    @Test
    public void testCrateFromGameState_whenHealthIsZero_thenResetStats() {
        GameState gameState = GameState.createState("name",0,20);
        Player player = new Player(gameState);
        assertEquals("name",player.getName());
        assertEquals(0,player.getHealth());
        assertEquals(0,player.getScore());
    }


}