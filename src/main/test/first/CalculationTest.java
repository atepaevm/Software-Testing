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
    public void testFirst() throws Exception{
        //(-oo;-1)
        testPoint(-10.12);
        testPoint(-123.32342);
        testPoint(-29885687);
    }
    @Test
    public void testSecond() throws Exception{
        //(-1;-0.5)
        testPoint(-0.99);
        testPoint(-0.74);
        testPoint(-0.58);
    }
    @Test
    public void testThird() throws Exception{
        //(-0.5;0)
        testPoint(-0.43);
        testPoint(-0.25);
        testPoint(-0.05);
    }
    @Test
    public void testFourth() throws Exception{
        //(0;0.5)
        testPoint(0.14);
        testPoint(0.27);
        testPoint(0.47);
    }
    @Test
    public void testFifth() throws Exception{
        //(0.5;1)
        testPoint(0.7);
        testPoint(0.81);
        testPoint(0.98);
    }
    @Test
    public void testSixth() throws Exception{
        //(1;+oo)
        testPoint(+124333.2);
        testPoint(26582.954);
        testPoint(1.2323);
    }
    @Test
    public void testExtraPoints() throws Exception {
        testPoint(-1);
        testPoint(-0.5);
        testPoint(0);
        testPoint(0.5);
        testPoint(1);
    }
}