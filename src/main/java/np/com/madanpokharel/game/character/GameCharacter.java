package np.com.madanpokharel.game.character;

import np.com.madanpokharel.game.Position;
import np.com.madanpokharel.game.Positionable;

public abstract class GameCharacter implements Positionable {
    protected int health;
    protected int impact;
    protected int visibility;
    protected Position position;

    public GameCharacter(int impact, int visibility,Position position) {
        this.health = 100;
        this.impact = impact;
        this.visibility=visibility;
        this.position =position;
    }


    public void attacked(int impact) {
        this.health -= impact;
    }

    public boolean isDead(){
        return health<=0;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void updatePosition(Position position) {
        this.position = position;
    }

    public void attack(GameCharacter character){
        character.attacked(this.impact);
    }

    public boolean isInRange(GameCharacter character){
       return this.position.isWithinRange(character.getPosition(),visibility);
    }

    public int getHealth() {
        return health;
    }

    public int getImpact() {
        return impact;
    }

    public int getVisibility() {
        return visibility;
    }
}
