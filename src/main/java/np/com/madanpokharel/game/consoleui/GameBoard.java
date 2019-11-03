package np.com.madanpokharel.game.consoleui;

import np.com.madanpokharel.game.Position;
import np.com.madanpokharel.game.Positionable;
import np.com.madanpokharel.game.character.GameCharacter;

import java.util.Optional;
import java.util.Random;

public class GameBoard {
    private Positionable[][] grid;
    private int width;
    private int height;

    private GameBoard(int w, int h) {
        this.width = w;
        this.height = h;
        grid = new Positionable[w][h];
    }

    public static GameBoard create(int width, int height) {
        return new GameBoard(width, height);
    }

    public Position placeCharacterRandomly(GameCharacter gameCharacter) {
        Random random = new Random();
        int yCoordinate = random.nextInt(height);
        int xCoordinate = random.nextInt(width);
        grid[yCoordinate][xCoordinate] = gameCharacter;
        return new Position(xCoordinate, yCoordinate, width, height);
    }

    public void removeCharacterAt(Position position) {
        grid[position.getyCor()][position.getxCor()] = null;
    }

    public void addCharacter(GameCharacter character){
        grid[character.getPosition().getyCor()][character.getPosition().getxCor()]=character;
    }

    public String getView(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Positionable[] positionables : grid) {
            for (Positionable string : positionables) {
                String characterRepresentation = Optional.ofNullable(string)
                        .map(Positionable::getDisplayCharacter).orElse(".");
                stringBuilder.append(characterRepresentation).append("\t");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Positionable[][] getGrid() {
        return grid.clone();
    }
}
