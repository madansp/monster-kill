package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.consoleui.GameBoard;
import np.com.madanpokharel.game.consoleui.MainScreen;
import np.com.madanpokharel.game.event.GameEndEventListener;
import np.com.madanpokharel.game.event.GameEndEventListener.EndType;
import np.com.madanpokharel.game.event.GameEventListener;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameController implements GameEventListener {
    private GameBoard gameBoard;
    private Player player;
    private List<GameCharacter> characters;
    private MainScreen mainScreen;
    private GameEndEventListener gameEndEventListener;

    public GameController(GameBoard gameBoard, Player player, List<GameCharacter> characters,
                          MainScreen mainScreen) {

        Objects.requireNonNull(gameBoard);
        Objects.requireNonNull(player);
        Objects.requireNonNull(characters);
        Objects.requireNonNull(mainScreen);

        this.gameBoard = gameBoard;
        this.player = player;
        this.characters = characters;
        this.mainScreen = mainScreen;
        this.mainScreen.addEventListener(this);
        this.gameEndEventListener = mainScreen;
    }

    public static GameControllerBuilder initializer() {
        return new GameControllerBuilder();
    }

    @Override
    public void enemyFound(GameCharacter character) {
        mainScreen.showPlayerAttackedMonsterMessage();

        player.attack(character);
        player.increaseScore();
        if (character.isDead()) {
            gameBoard.removeCharacterAt(character.getPosition());
            characters.remove(character);
        }
        if (characters.size() == 1) {
            gameEndEventListener.gameEnded(EndType.WIN);
        }
    }

    @Override
    public void playerMoved(Position position) {
        gameBoard.removeCharacterAt(player.getPosition());
        player.updatePosition(position);
        gameBoard.addCharacter(player);
    }

    @Override
    public void screenUpdated() {
        List<GameCharacter> monsters = characters
                .stream()
                .filter(e -> !e.equals(player)).collect(Collectors.toList());

        monsters.forEach(character -> {
            gameBoard.removeCharacterAt(character.getPosition());
            Position move = ((AutoMoveable) character).move();
            character.updatePosition(move);
            gameBoard.addCharacter(character);
        });

        monsters.stream().filter(e -> e.isInRange(player))
                .findFirst()
                .ifPresent(e -> {
                    e.attack(player);
                    mainScreen.monsterAttackedPlayerMessage();
                });

        if (player.isDead()) {
            gameEndEventListener.gameEnded(EndType.LOOSE);
        }
    }

    @Override
    public void gameExited() {
        mainScreen.showGoodByeMessage();
        GameState gameState = GameState.createState(player.getName(), player.getHealth(), player.getScore());
        FileUtils.createFileOfGameState(player.getName(), gameState);
    }

    public void showScreen() {
        mainScreen.showGameBoard();
        mainScreen.startGame();
    }


}
