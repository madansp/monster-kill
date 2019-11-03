package np.com.madanpokharel.game.consoleui;

import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.event.GameEndEventListener.EndType;
import np.com.madanpokharel.game.event.GameEventListener;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainScreenTest {


    @InjectMocks
    private MainScreen mainScreen;

    @Mock
    private PrintStream printStream;

    @Mock
    private GameBoard gameBoard;

    @Mock
    private GameEventListener gameEventListener;

    @Mock
    private Player player;

    @Before
    public void setUp() {
        System.setOut(printStream);
    }

    @AfterClass
    public static void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testShowPlayerAttackedMonsterMessage() {
        mainScreen.showPlayerAttackedMonsterMessage();
        verify(printStream).println(eq("\u001B[32m you hit monster \u001B[0m"));
    }

    @Test
    public void testMonsterAttackedPlayerMessage() {
        mainScreen.monsterAttackedPlayerMessage();
        verify(printStream).println(eq("\u001B[31m you have been attacked by monster \u001B[0m"));
    }

    @Test
    public void testShowGoodbyeMessage() {
        mainScreen.showGoodByeMessage();
        verify(printStream).println(eq("Good bye!! see you later"));
    }

    @Test
    public void whenGameEnded_setIsGameEndedToTrue() {
        mainScreen.addEventListener(gameEventListener);
        mainScreen.gameEnded(EndType.WIN);
        Assert.assertTrue(mainScreen.isGameEnded());
    }

    @Test
    public void testGameEndedTypeWin() {
        mainScreen.addEventListener(gameEventListener);
        mainScreen.gameEnded(EndType.WIN);
        verify(printStream).println(eq("Hurray!! you win the game"));
        verify(gameEventListener).gameExited();
    }

    @Test
    public void testGameEndedTypeLoose() {
        mainScreen.addEventListener(gameEventListener);
        mainScreen.gameEnded(EndType.LOOSE);
        verify(printStream).println(eq("Sorry you are dead. Play again"));
        verify(gameEventListener).gameExited();
    }

    @Test
    public void testShowGameBoard() {
        when(gameBoard.getView()).thenReturn("game board view");
        mainScreen.showGameBoard();
        verify(printStream).println(eq("game board view"));
    }
}