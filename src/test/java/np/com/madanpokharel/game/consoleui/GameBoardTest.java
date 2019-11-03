package np.com.madanpokharel.game.consoleui;

import np.com.madanpokharel.game.Position;
import np.com.madanpokharel.game.character.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {

    @Test
    public void whenCreate_shouldInitializeGameGrid() {
        GameBoard gameBoard = GameBoard.create(10,10);
        assertNotNull(gameBoard.getGrid());
        assertEquals(10,gameBoard.getGrid().length);
        assertEquals(10,gameBoard.getGrid()[0].length);
    }

    @Test
    public void testPlaceCharacterAtRandomPlace() {
        GameBoard gameBoard = GameBoard.create(10,10);
        Player player = new Player("test");
        Position position = gameBoard.placeCharacterRandomly(player);
        assertEquals(player,gameBoard.getGrid()[position.getyCor()][position.getxCor()]);
    }

    @Test
    public void testRemoveCharacterFromPosition() {
        GameBoard gameBoard = GameBoard.create(10,10);
        Player player = new Player("test");
        Position position = gameBoard.placeCharacterRandomly(player);
        assertEquals(player,gameBoard.getGrid()[position.getyCor()][position.getxCor()]);
        gameBoard.removeCharacterAt(position);
        assertNull(gameBoard.getGrid()[position.getyCor()][position.getxCor()]);
    }

    @Test
    public void testAddCharacter() {
        GameBoard gameBoard = GameBoard.create(10,10);
        Player player = new Player("test");
        player.updatePosition(new Position(5,5,10,10));
        assertNull(gameBoard.getGrid()[5][5]);
        gameBoard.addCharacter(player);
        assertEquals(player,gameBoard.getGrid()[5][5]);
    }

    @Test
    public void testGetView() {
        GameBoard gameBoard = GameBoard.create(10,10);
        Player player = new Player("test");
        player.updatePosition(new Position(5,5,10,10));
        gameBoard.addCharacter(player);

        String view=".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t\u001B[32m\uD83D\uDE2E\u001B[0m\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t.\t.\t.\t.\t.\t\n";

        String gameBoardView = gameBoard.getView();

        assertEquals(view,gameBoardView);
    }
}