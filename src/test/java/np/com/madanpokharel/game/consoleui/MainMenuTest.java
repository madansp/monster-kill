package np.com.madanpokharel.game.consoleui;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void whenGetUserInput_shouldReturnUserInput() {
        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MainMenu mainMenu = new MainMenu();
        UserAction userInput = mainMenu.getUserInput();
        assertEquals(UserAction.U,userInput);
    }

    @Test
    public void givenInvalidUserInput_whenGetUserInput_shouldReturnUserInputN() {
        String input = "INVALID";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MainMenu mainMenu = new MainMenu();
        UserAction userInput = mainMenu.getUserInput();
        assertEquals(UserAction.N,userInput);
    }
}