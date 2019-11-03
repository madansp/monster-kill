package np.com.madanpokharel.game.consoleui;


import np.com.madanpokharel.game.MovementType;
import np.com.madanpokharel.game.Position;

public enum UserAction {
    U, D, L, R, F, E, N;

    public static UserAction safeValueOf(String input) {
        try {
            return UserAction.valueOf(input.toUpperCase());
        } catch (Exception ex) {
            return UserAction.N;
        }
    }

    public Position move(Position currentPosition) {
        return currentPosition.move(MovementType.valueFrom(this.name()));
    }

    public boolean isAction() {
        return this == F;
    }

    public boolean isMovement() {
        return !isAction() && this != N && !isExit();
    }

    public boolean isExit() {
        return this == E;
    }
}
