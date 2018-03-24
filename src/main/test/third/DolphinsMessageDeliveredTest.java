package third;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DolphinsMessageDeliveredTest {

    private DolphinsMessage message;
    private Flip flip;
    private WhistleSound sound = WhistleSound.Kalinka;
    private AmusmentLevel level = AmusmentLevel.NOT_FUNNY;

    @Before
    public void initialize(){
        this.flip = new Flip(FlipStyle.Oridnary, Direction.BACKWARD, Item.FIRE);
        this.message = new DolphinsMessage(this.flip, "Example string");
        this.message.deliverMessage(this.sound, this.level);
    }

    @Test
    public void messageSoundCheck(){
        assertEquals(this.message.sound, sound);
    }

    @Test
    public void messageAmusementCheck(){
        assertEquals(this.message.actionAmusement, level);
    }

    @Test
    public void filpStateChangedCheck(){
        assertEquals(this.flip.getFlipState(), true);
    }

}
