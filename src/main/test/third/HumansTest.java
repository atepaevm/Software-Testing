package third;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumansTest {

    private Humans humans;

    @Before
    public void initialize(){
        this.humans = new Humans();
    }

    @Test
    public void humansCantUnderstandMessageCheck(){
        assertEquals(this.humans.canUnderstandMessage, false);
    }

}
