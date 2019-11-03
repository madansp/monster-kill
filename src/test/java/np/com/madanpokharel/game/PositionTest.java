package np.com.madanpokharel.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenXCorIsGreaterThanWidth_thenThrowException() {
        new Position(15, 5, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenYCorIsGreaterThanHeight_thenThrowException() {
        new Position(8, 25, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenYCorIsNegative_thenThrowException() {
        new Position(8, -5, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenXCorIsNegative_thenThrowException() {
        new Position(-8, 5, 10, 10);
    }

    @Test
    public void whenMoveRight_IncreaseXCor() {
        Position position = new Position(8, 5, 10, 10);
        Position newPosition = Position.moveRight(position);
        assertEquals(9, newPosition.getxCor());
    }
    @Test
    public void givenXCorIsTouchingWidth_whenMoveRight_setXCorZero() {
        Position position = new Position(9, 5, 10, 10);
        Position newPosition = Position.moveRight(position);
        assertEquals(0, newPosition.getxCor());
    }

    @Test
    public void whenMoveLeft_DecreaseXCor() {
        Position position = new Position(8, 5, 10, 10);
        Position newPosition = Position.moveLeft(position);
        assertEquals(7, newPosition.getxCor());
    }
    @Test
    public void givenXCorIsZero_whenMoveLeft_setXCorToWidthMinusOne() {
        Position position = new Position(0, 5, 10, 10);
        Position newPosition = Position.moveLeft(position);
        assertEquals(9, newPosition.getxCor());
    }

    @Test
    public void whenMoveDown_IncreaseYCor() {
        Position position = new Position(8, 5, 10, 10);
        Position newPosition = Position.moveDown(position);
        assertEquals(6, newPosition.getyCor());
    }
    @Test
    public void givenYCorIsTouchingHeight_whenMoveDown_setYCorZero() {
        Position position = new Position(9, 9, 10, 10);
        Position newPosition = Position.moveDown(position);
        assertEquals(0, newPosition.getyCor());
    }

    @Test
    public void whenMoveUp_DecreaseYCor() {
        Position position = new Position(8, 5, 10, 10);
        Position newPosition = Position.moveUp(position);
        assertEquals(4, newPosition.getyCor());
    }
    @Test
    public void givenYCorIsZero_whenMoveUp_setYCorToHeightMinusOne() {
        Position position = new Position(0, 0, 10, 10);
        Position newPosition = Position.moveUp(position);
        assertEquals(9, newPosition.getyCor());
    }
    @Test
    public void testWithinRange() {
        /*
         *  0 0 0 0 0
         *  0 0 2,1 0 0
         *  0 0 0 0 0
         *  0 0 0 0 0
         *  0 0 2,4 0 0
         */
        Position position = new Position(2, 1, 5, 5);

        assertTrue(new Position(0, 1, 5, 5).isWithinRange(position, 2));
        assertTrue(new Position(4, 1, 5, 5).isWithinRange(position, 2));
        assertTrue(new Position(2, 3, 5, 5).isWithinRange(position, 2));
        assertTrue(new Position(2, 0, 5, 5).isWithinRange(position, 2));
        assertTrue(new Position(2, 1, 5, 5).isWithinRange(position, 2));

        assertFalse(new Position(2, 4, 5, 5).isWithinRange(position, 2));
    }
}