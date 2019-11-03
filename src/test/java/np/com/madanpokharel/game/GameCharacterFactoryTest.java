package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameCharacterFactoryTest {

    @Test
    public void testCreateCharacters() {
        List<GameCharacter> characters = GameCharacterFactory.createCharacters();
        assertEquals(8,characters.size());
    }
}