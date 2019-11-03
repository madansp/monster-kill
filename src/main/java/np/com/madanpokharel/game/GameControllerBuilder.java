package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.consoleui.GameBoard;
import np.com.madanpokharel.game.consoleui.MainScreen;
import np.com.madanpokharel.game.consoleui.Menu;

import java.util.List;
import java.util.Objects;

public class GameControllerBuilder {
    private GameBoard gameBoard;
    private Player player;
    private List<GameCharacter> characters;
    private Menu menu;
    private MainScreen mainScreen;

    public GameControllerBuilder initBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        return this;
    }

    public GameControllerBuilder initPlayer(Player player) {
        Objects.requireNonNull(characters);

        this.player = player;
        characters.add(player);
        return this;
    }

    public GameControllerBuilder initCharacters() {
        Objects.requireNonNull(gameBoard);

        this.characters = GameCharacterFactory.createCharacters();
        return this;
    }

    public GameControllerBuilder placeCharactersOnBoard() {
        Objects.requireNonNull(characters);

        for (GameCharacter character : characters) {
            Position position = gameBoard.placeCharacterRandomly(character);
            character.updatePosition(position);
        }
        return this;
    }

    public GameControllerBuilder initMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public GameControllerBuilder initMainScreen() {
        Objects.requireNonNull(gameBoard);
        Objects.requireNonNull(player);
        Objects.requireNonNull(menu);
        Objects.requireNonNull(characters);
        this.mainScreen = new MainScreen(gameBoard, player, menu, characters);
        return this;
    }

    public GameController build() {
        return new GameController(this.gameBoard, this.player, this.characters, this.mainScreen);
    }

    GameBoard getGameBoard() {
        return gameBoard;
    }

    Player getPlayer() {
        return player;
    }

    List<GameCharacter> getCharacters() {
        return characters;
    }

    Menu getMenu() {
        return menu;
    }

    MainScreen getMainScreen() {
        return mainScreen;
    }
}
