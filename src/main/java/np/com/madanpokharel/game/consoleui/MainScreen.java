package np.com.madanpokharel.game.consoleui;

import np.com.madanpokharel.game.AutoMoveable;
import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.event.GameEndEventListener;
import np.com.madanpokharel.game.event.GameEventListener;

import java.util.List;

public class MainScreen implements GameEndEventListener {

    private boolean isGameEnded;
    private GameBoard gameBoard;
    private Player player;
    private List<GameCharacter> characters;
    private Menu menu;
    private GameEventListener gameEventListener;

    public MainScreen(GameBoard board, Player player, Menu menu, List<GameCharacter> characters) {
        this.gameBoard = board;
        this.player = player;
        this.menu = menu;
        this.characters = characters;
    }

    public void startGame() {
        while (!isGameEnded) {
            UserAction userInput = menu.getUserInput();
            if (userInput.isAction()) {
                characters.stream()
                        .filter(e -> e instanceof AutoMoveable)
                        .filter(e -> player.isInRange(e))
                        .findFirst()
                        .ifPresent(e -> gameEventListener.enemyFound(e));
            } else if (userInput.isMovement()) {
                gameEventListener.playerMoved(userInput.move(player.getPosition()));
                gameEventListener.screenUpdated();
            }
            else if (userInput.isExit()){
                gameEventListener.gameExited();
                break;
            }

            showGameBoard();
        }
    }

    public void showGameBoard() {
        System.out.println(String.format("\u001B[43m Name: %s, Health: %d, Score: %d \u001B[0m",player.getName(),
                player.getHealth(),player.getScore()));
        System.out.println(gameBoard.getView());
    }

    public void showPlayerAttackedMonsterMessage() {
        System.out.println("\u001B[32m you hit monster \u001B[0m");
    }

    public void showGoodByeMessage(){
        System.out.println("Good bye!! see you later");
    }

    public void addEventListener(GameEventListener listener) {
        this.gameEventListener = listener;
    }


    @Override
    public void gameEnded(EndType endType) {
        isGameEnded = true;
        this.gameEventListener.gameExited();

        if (endType==EndType.WIN){
            System.out.println("Hurray!! you win the game");
        }else {
            System.out.println("Sorry you are dead. Play again");
        }
    }

    public void monsterAttackedPlayerMessage() {
        System.out.println("\u001B[31m you have been attacked by monster \u001B[0m");
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }
}
