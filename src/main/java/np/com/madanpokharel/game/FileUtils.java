package np.com.madanpokharel.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;
import java.util.Optional;

public class FileUtils {

    public static Optional<String> readFileContent(String file) {
        InputStream resourceAsStream = FileUtils.class.getClassLoader().getResourceAsStream(file);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(resourceAsStream)))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (Exception ex) {
            return Optional.empty();
        }
        return Optional.of(resultStringBuilder.toString());
    }

    public static Optional<GameState> readScoreFile(String playerName){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(playerName + ".msk"));
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            GameState gameState = (GameState) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            return Optional.of(gameState);
        }catch (Exception ex){
            return Optional.empty();
        }
    }

    public static void createFileOfGameState(String fileName, GameState gameState) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName + ".msk"));
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(gameState);
            outputStream.close();
            fileOutputStream.close();
        }catch (Exception ex){
            System.out.println("something went wrong, not able to save score");
        }
    }
}
