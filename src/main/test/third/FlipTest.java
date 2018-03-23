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
    public void initialValuesCheck(){
        assertEquals(flip.direction, direction);
        assertEquals(flip.obstacle, item);
        assertEquals(flip.style, style);
    }

    @Test
    public void doFlipCheck(){
        assertEquals(this.flip.getFlipState(), false);
        this.flip.doFlip();
        assertEquals(this.flip.getFlipState(), true);
        this.flip.resetFlipState();
        assertEquals(this.flip.getFlipState(), false);

        this.flip.style = style2;
        this.flip.doFlip();
        assertEquals(this.flip.getFlipState(), true);
    }
}
