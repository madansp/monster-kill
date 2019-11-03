package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.consoleui.GameBoard;
import np.com.madanpokharel.game.consoleui.MainMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerBuilderTest {

    @Test
    public void testInitBoard() {
        GameControllerBuilder builder = new GameControllerBuilder().initBoard(Mockito.mock(GameBoard.class));
        assertNotNull(builder.getGameBoard());
    }

    @Test
    public void testInitCharacters() {
        GameControllerBuilder builder = new GameControllerBuilder()
                .initBoard(Mockito.mock(GameBoard.class)).initCharacters();
        assertTrue(builder.getCharacters().size()>0);
    }

    @Test
    public void testInitPlayer() {
        Player player = new Player("test");
        GameControllerBuilder builder = new GameControllerBuilder()
                .initBoard(Mockito.mock(GameBoard.class)).initCharacters().initPlayer(player);
        assertTrue(builder.getCharacters().contains(player));
        assertNotNull(builder.getPlayer());
    }

    @Test
    public void testPlaceCharactersOnBoard() {
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        when(gameBoard.placeCharacterRandomly(any(GameCharacter.class))).thenReturn(Position.INITIAL);
        GameControllerBuilder builder = new GameControllerBuilder()
                .initBoard(gameBoard).initCharacters().placeCharactersOnBoard();

        verify(gameBoard,times(8)).placeCharacterRandomly(any(GameCharacter.class));

        assertEquals(builder.getCharacters().get(0).getPosition(),Position.INITIAL);
    }

    @Test
    public void testInitMenu() {
        GameControllerBuilder builder = new GameControllerBuilder().initMenu(new MainMenu());
        assertNotNull(builder.getMenu());
    }

    @Test
    public void testInitMainScreen() {
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        when(gameBoard.placeCharacterRandomly(any(GameCharacter.class))).thenReturn(Position.INITIAL);
        GameControllerBuilder builder = new GameControllerBuilder()
                .initBoard(gameBoard)
                .initCharacters()
                .initPlayer(new Player("test"))
                .placeCharactersOnBoard()
                .initMenu(new MainMenu())
                .initMainScreen();

        assertNotNull(builder.getMainScreen());
    }

    @Test
    public void testBuildGameController() {
        GameBoard gameBoard = Mockito.mock(GameBoard.class);
        when(gameBoard.placeCharacterRandomly(any(GameCharacter.class))).thenReturn(Position.INITIAL);
        GameController controller = new GameControllerBuilder()
                .initBoard(gameBoard)
                .initCharacters()
                .initPlayer(new Player("test"))
                .placeCharactersOnBoard()
                .initMenu(new MainMenu())
                .initMainScreen().build();

        assertNotNull(controller);
    }
}