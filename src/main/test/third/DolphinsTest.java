package third;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DolphinsTest {

    private Dolphins dolphins;
    private DolphinsMessage message1, message2;

    @Before
    public void initialize(){
        Flip flip1, flip2;

        this.dolphins = new Dolphins();

        flip1 = new Flip(FlipStyle.Oridnary, Direction.FORWARD, Item.FIRE);
        flip2 = new Flip(FlipStyle.Tripple, Direction.BACKWARD, Item.HOOP);

        this.message1 = new DolphinsMessage(flip1, "Example1");
        this.message2 = new DolphinsMessage(flip2, "Example2");
    }


    @Test
    public void lastMessageCheck(){
        dolphins.addMessage(message1);
        dolphins.addMessage(message2);

        DolphinsMessage resultMessage = dolphins.getLastMessage();

        assertEquals(message2, resultMessage);
    }
}
