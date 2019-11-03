package np.com.madanpokharel.game;

import np.com.madanpokharel.game.character.GameCharacter;
import np.com.madanpokharel.game.character.Chupacabra;
import np.com.madanpokharel.game.character.Nessie;

import java.util.ArrayList;
import java.util.List;

public class GameCharacterFactory {

    public static List<GameCharacter> createCharacters(){
        List<GameCharacter> list = new ArrayList<>();
        list.add(new Chupacabra(Position.INITIAL));
        list.add(new Chupacabra(Position.INITIAL));
        list.add(new Nessie(Position.INITIAL));
        list.add(new Nessie(Position.INITIAL));
        list.add(new Chupacabra(Position.INITIAL));
        list.add(new Chupacabra(Position.INITIAL));
        list.add(new Nessie(Position.INITIAL));
        list.add(new Nessie(Position.INITIAL));
        return list;
    }
}
