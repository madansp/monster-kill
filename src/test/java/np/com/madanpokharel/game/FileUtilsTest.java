package np.com.madanpokharel.game;

import org.junit.Test;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void givenValidFileNameWithContent_whenReadFile_shouldReturnFileContent() {
        Optional<String> fileContent = FileUtils.readFileContent("sample-file.txt");
        assertTrue(fileContent.isPresent());
        assertEquals("hello from file\n",fileContent.get());
    }

    @Test
    public void givenInValidFile_whenReadFile_shouldReturnEmpty() {
        Optional<String> fileContent = FileUtils.readFileContent("sample-file_invalid.txt");
        assertFalse(fileContent.isPresent());
    }

    @Test
    public void testCreateScoreFile() {
        GameState gameState = GameState.createState("madan",100,10);
        String fileName = "target/"+UUID.randomUUID().toString();
        FileUtils.createFileOfGameState(fileName,gameState);
        File file = new File(fileName+".msk");
        assertTrue(file.exists());
    }

    @Test
    public void testReadScoreFile() {
        GameState gameState = GameState.createState("madan",100,10);
        String fileName = "target/"+UUID.randomUUID().toString();
        FileUtils.createFileOfGameState(fileName,gameState);

        Optional<GameState> optional = FileUtils.readScoreFile(fileName);
        assertTrue(optional.isPresent());

        GameState gameState1 = optional.get();
        assertEquals("madan", gameState1.getName());
        assertEquals(100, gameState1.getHealth());
        assertEquals(10, gameState1.getScore());
    }
}