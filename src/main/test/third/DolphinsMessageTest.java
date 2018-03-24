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
    public void messageTrueMeaningCheck() {
        assertSame(this.text, this.message1.getMessageMeaning(true));
    }

    @Test
    public void messageFalseMeaningCheck() {
        assertEquals(null, this.message1.getMessageMeaning(false));
    }

    @Test
    public void flip1SameObjectCheck() {
        assertSame(this.message1.flip, flip1);
    }

    @Test
    public void flip2SameObjectCheck() {
        assertSame(this.message2.flip, flip2);
    }
}
