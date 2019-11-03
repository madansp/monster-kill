package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Chupacabra;
import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.consoleui.GameBoard;
import np.com.madanpokharel.game.consoleui.MainScreen;
import np.com.madanpokharel.game.event.GameEndEventListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {


    private GameController controller;
    @Mock
    private GameBoard gameBoard;
    @Mock
    private Player player;
    @Mock
    private MainScreen mainScreen;

    private List<GameCharacter> characters= new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        controller= new GameController(gameBoard,player, characters,mainScreen);
    }

    @Test
    public void whenEnemyFound_showMessageOnMainScreenAndAttackAndIncreaseScore() {
        GameCharacter gameCharacter = mock(GameCharacter.class);
        controller.enemyFound(gameCharacter);
        verify(mainScreen).showPlayerAttackedMonsterMessage();
        verify(player).attack(eq(gameCharacter));
        verify(player).increaseScore();

    }

    @Test
    public void whenEnemyFoundAndBecomeDead_thenRemoveFromBoardAndList() {
        GameCharacter gameCharacter = mock(GameCharacter.class);
        when(gameCharacter.isDead()).thenReturn(true);
        when(gameCharacter.getPosition()).thenReturn(mock(Position.class));

        characters.add(gameCharacter);
        controller.enemyFound(gameCharacter);
        verify(gameBoard).removeCharacterAt(any(Position.class));
        Assert.assertFalse(characters.contains(gameCharacter));
    }

    @Test
    public void whenEnemyFoundAndListHasOnlyOneCharacter_thenFireEvent() {
        GameCharacter gameCharacter = mock(GameCharacter.class);
        characters.add(gameCharacter);
        controller.enemyFound(gameCharacter);
        verify(mainScreen).gameEnded(GameEndEventListener.EndType.WIN);
    }

    @Test
    public void showGameBoardAndStartGame_whenShowScreen() {
        controller.showScreen();
        verify(mainScreen).showGameBoard();
        verify(mainScreen).startGame();
    }

    @Test
    public void whenPlayerMoved_shouldUpdatePlayerPositionAndPositionOnGameBoard() {
        Position playerPosition = mock(Position.class);
        when(player.getPosition()).thenReturn(playerPosition);
        Position position = mock(Position.class);
        controller.playerMoved(position);
        verify(gameBoard).removeCharacterAt(playerPosition);
        verify(player).updatePosition(eq(position));
        verify(gameBoard).addCharacter(eq(player));
    }

    @Test
    public void whenScreenUpdate_thenMoveMonstersToNewPosition() {
        Position position = Position.INITIAL;
        GameCharacter monster = spy(new Chupacabra(position));
        when(player.getPosition()).thenReturn(Position.INITIAL);
        characters.add(monster);
        controller.screenUpdated();
        verify(gameBoard).removeCharacterAt(eq(position));
        verify(monster).updatePosition(any());
        verify(gameBoard).addCharacter(eq(monster));
    }

    @Test
    public void whenMonsterFoundPlayerInRange_thenShouldAttackPlayerAndShowMessage() {
        Position position = Position.INITIAL;
        GameCharacter monster = spy(new Chupacabra(position));
        when(player.getPosition()).thenReturn(Position.INITIAL);
        characters.add(monster);
        controller.screenUpdated();

        verify(monster).attack(eq(player));
        verify(mainScreen).monsterAttackedPlayerMessage();
    }

    @Test
    public void whenPlayerIsDead_thenFireEvent() {
        Position position = Position.INITIAL;
        GameCharacter monster = spy(new Chupacabra(position));
        when(player.getPosition()).thenReturn(Position.INITIAL);
        when(player.isDead()).thenReturn(true);
        characters.add(monster);
        controller.screenUpdated();
        verify(mainScreen).gameEnded(eq(GameEndEventListener.EndType.LOOSE));
    }

    @Test
    public void testInitializer() {
        assertNotNull(GameController.initializer());
    }
}