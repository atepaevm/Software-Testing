package first;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 12 on 19.03.2018.
 */
public class CalculationTest {
    private void testPoint(double X){
        double deltaX=0.0001;
        double deltaY=0.0005;
        Calculation calc=new Calculation();
        double res=calc.arcsin(X+deltaX);
        assertEquals(Math.asin(X-deltaX),calc.arcsin(X-deltaX),deltaY);
        assertEquals(Math.asin(X),calc.arcsin(X),deltaY);
        assertEquals(Math.asin(X+deltaX),calc.arcsin(X+deltaX),deltaY);
    }
    @Test
    public void testArcsin() throws Exception {
        //first interval
        testPoint(-0.99);
        testPoint(-0.74);
        testPoint(-0.58);
        //second interval
        testPoint(-0.43);
        testPoint(-0.25);
        testPoint(-0.05);
        //third interval
        testPoint(0.14);
        testPoint(-0.27);
        testPoint(-0.47);
        //fourth interval
        testPoint(0.7);
        testPoint(0.81);
        testPoint(0.98);
        //test extra points
        testPoint(-1);
        testPoint(-0.5);
        testPoint(0);
        testPoint(0.5);
        testPoint(1);


    }

}