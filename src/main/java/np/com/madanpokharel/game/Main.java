package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.Player;
import np.com.madanpokharel.game.consoleui.GameBoard;
import np.com.madanpokharel.game.consoleui.InputBox;
import np.com.madanpokharel.game.consoleui.MainMenu;

public class Main {
    public static void main(String[] args) {
        FileUtils.readFileContent("game_banner.txt").ifPresent(System.out::print);
        System.out.println("do you want to see instructions? press y for yes, any other key for no");
        String answer = InputBox.readString();
        if (answer.equalsIgnoreCase("y")) {
            FileUtils.readFileContent("game_instructions.txt").ifPresent(System.out::print);
        }

        System.out.println("please enter your name");
        String name = InputBox.readString();

        Player player = FileUtils.readScoreFile(name)
                .map(Player::new)
                .orElse(new Player(name));

        GameController gameController = GameController
                .initializer()
                .initBoard(GameBoard.create(10, 10))
                .initMenu(new MainMenu())
                .initCharacters()
                .initPlayer(player)
                .placeCharactersOnBoard()
                .initMainScreen()
                .build();

        gameController.showScreen();

    }
}
