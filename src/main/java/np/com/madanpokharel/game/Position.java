package np.com.madanpokharel.game;

public class Position {
    private int xCor;
    private int yCor;
    private int width;
    private int height;

    public static final Position INITIAL = new Position(0, 0, 1, 1);

    public Position(int xCor, int yCor, int width, int height) {
        this.xCor = xCor;
        this.yCor = yCor;
        if (xCor > width - 1 || xCor < 0) {
            throw new IllegalArgumentException("invalid x cor");
        }
        if (yCor > height - 1 || yCor < 0) {
            throw new IllegalArgumentException("invalid y cor");
        }
        this.width = width;
        this.height = height;
    }

    public boolean isWithinRange(Position position, int range) {
        int diffX = Math.abs(position.xCor - xCor);
        int diffY = Math.abs(position.yCor - yCor);

        if (diffX == 0 && diffY == 0) {
            return true;
        }

        if (diffX == 0) {
            return diffY <= range;
        }
        if (diffY == 0) {
            return diffX <= range;
        }
        return false;
    }

    public Position move(MovementType type) {
        Position position = new Position(xCor,yCor,width,height);
        if (type == MovementType.LEFT) {
            return moveLeft(position);
        } else if (type == MovementType.RIGHT) {
            return moveRight(position);
        } else if (type == MovementType.UP) {
           return moveUp(position);
        } else if (type == MovementType.DOWN) {
            return moveDown(position);
        }
        return position;
    }

    public static Position moveUp(Position position) {
        position.yCor -= 1;
        if (position.yCor < 0) {
            position.yCor = position.height - 1;
        }
        return new Position(position.xCor,position.yCor,position.width,position.height);
    }

    public static Position moveDown(Position position) {
        position.yCor += 1;
        if (position.yCor > position.height - 1) {
            position.yCor = 0;
        }
        return new Position(position.xCor,position.yCor,position.width,position.height);
    }

    public static Position moveLeft(Position position) {
        position.xCor -= 1;
        if (position.xCor < 0) {
            position.xCor = position.width - 1;
        }
        return new Position(position.xCor,position.yCor,position.width,position.height);
    }

    public static Position moveRight(Position position) {
        position.xCor += 1;
        if (position.xCor > position.width - 1) {
            position.xCor = 0;
        }
        return new Position(position.xCor,position.yCor,position.width,position.height);
    }

    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (xCor != position.xCor) return false;
        if (yCor != position.yCor) return false;
        if (width != position.width) return false;
        return height == position.height;

    }

    @Override
    public int hashCode() {
        int result = xCor;
        result = 31 * result + yCor;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}
