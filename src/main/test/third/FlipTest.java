package third;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlipTest {

    private FlipStyle style, style2;
    private Direction direction;
    private Item item;
    private Flip flip;

    @Before
    public void initialize(){
        this.direction = Direction.BACKWARD;
        this.style = FlipStyle.Oridnary;
        this.style2 = FlipStyle.Tripple;
        this.item = Item.FIRE;

        this.flip = new Flip(style, direction, item);
    }

    @Test
    public void checkInitialState(){
        assertEquals(this.flip.getFlipState(), false);
    }

    @Test
    public void checkInitialDirection(){
        assertEquals(flip.direction, direction);
    }

    @Test
    public void checkInitialItem(){
        assertEquals(flip.obstacle, item);
    }

    @Test
    public void checkStateFlipped(){
        this.flip.doFlip();
        assertEquals(this.flip.getFlipState(), true);
    }

    @Test
    public void checkResetedState(){
        this.flip.resetFlipState();
        assertEquals(this.flip.getFlipState(), false);
    }
}
