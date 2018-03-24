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
    public void messageCheckFlip() {
        assertSame(Main.message.flip, Main.flip);
    }

    @Test
    public void checkLastMessage() {
        assertSame(Main.message, Main.dolphins.getLastMessage());
    }

    @Test
    public void checkLastMessageMeaning() {
        assertEquals(Main.message.getMessageMeaning(true), this.message);
    }

    @Test
    public void mainMessageSoundCheck() {
        assertEquals(Main.message.sound, this.sound);
    }

    @Test
    public void mainMessageAmusementCheck() {
        assertEquals(Main.message.actionAmusement, level);
    }

    @Test
    public void mainFlipStateCheck() {
        assertEquals(Main.flip.getFlipState(), true);
    }

    @Test
    public void humansMessageCantUnderstandCheck() {
        assertEquals(Main.humans.canUnderstandMessage, false);
    }

    @Test
    public void humansMessageRecievedMessageNotPresent() {
        assertEquals(Main.humans.recievedMessage, null);
    }
}
