package third;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private FlipStyle style;
    private Direction direction;
    private Item item;
    private String message;
    private WhistleSound sound;
    private AmusmentLevel level;




    @Before
    public void initialize(){
        this.style = FlipStyle.Double;
        this.direction = Direction.BACKWARD;
        this.item = Item.HOOP;
        this.sound = WhistleSound.StarStripped;
        this.level = AmusmentLevel.VERY_FUNNY;
        this.message = "Прощайте, и спасибо за рыбу";

        Main.main(null);
    }

    @Test
    public void mainFlipCheck(){
        assertEquals(Main.flip.style, this.style);
        assertEquals(Main.flip.direction, this.direction);
        assertEquals(Main.flip.obstacle, this.item);

    }

    @Test
    public void mainDolphinsMessageCheck(){
        assertSame(Main.message.flip, Main.flip);
        assertSame(Main.message, Main.dolphins.getLastMessage());
        assertEquals(Main.message.getMessageMeaning(true), this.message);
    }

    @Test
    public void mainMessageDelivered(){
        assertEquals(Main.message.sound, this.sound);
        assertEquals(Main.message.actionAmusement, level);
        assertEquals(Main.flip.getFlipState(), true);
    }

    @Test
    public void humansMessageCheck(){
        assertEquals(Main.humans.canUnderstandMessage, false);
        assertEquals(Main.humans.recievedMessage, null);

    }
}
