package third;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DolphinsMessageTest {

    private DolphinsMessage message1, message2;
    private Flip flip1, flip2;
    private String text = "Example string";
    private WhistleSound sound = WhistleSound.Kalinka;
    private AmusmentLevel level = AmusmentLevel.NOT_FUNNY;


    @Before
    public void initialize(){
        this.flip1 = new Flip(FlipStyle.Oridnary, Direction.BACKWARD, Item.FIRE);
        this.flip2 = new Flip(FlipStyle.Tripple, Direction.BACKWARD, Item.HOOP);

        this.message1 = new DolphinsMessage(flip1, this.text);
        this.message2 = new DolphinsMessage(flip2, this.text);

    }

    @Test
    public void messageMeaningCheck(){
        assertSame(this.text, this.message1.getMessageMeaning(true));
    }

    @Test
    public void flipSameObjectCheck(){
        assertSame(this.message1.flip, flip1);
        assertSame(this.message2.flip, flip2);
    }

    @Test
    public void deliverMessageCheck(){
        this.message1.deliverMessage(sound, level);
        assertEquals(this.message1.sound, sound);
        assertEquals(this.message1.actionAmusement, level);
        assertEquals(flip1.getFlipState(), true);
    }
}
