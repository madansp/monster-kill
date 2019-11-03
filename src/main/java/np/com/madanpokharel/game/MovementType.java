package np.com.madanpokharel.game;

import java.util.Objects;

public enum MovementType {
    UP, DOWN, LEFT, RIGHT, NO_MOVEMENT;

    public static MovementType valueFrom(String value) {
        if (Objects.isNull(value) || value.trim().equals("")) {
            return NO_MOVEMENT;
        }
        if (value.equalsIgnoreCase("U")) {
            return UP;
        } else if (value.equalsIgnoreCase("D")) {
            return DOWN;
        } else if (value.equalsIgnoreCase("L")) {
            return LEFT;
        } else if (value.equalsIgnoreCase("R")) {
            return RIGHT;
        } else {
            return NO_MOVEMENT;
        }
    }
}
