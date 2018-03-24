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
    public void testFirst1() throws Exception{
        //(-oo;-1)
        testPoint(-10.12);
    }
    @Test
    public void testFirst2() throws Exception{
        //(-oo;-1)
        testPoint(-123.32342);
    }
    @Test
    public void testFirst3() throws Exception{
        //(-oo;-1)
        testPoint(-29885687);
    }
    @Test
    public void testSecond1() throws Exception{
        //(-1;-0.5)
        testPoint(-0.99);
    }
    @Test
    public void testSecond2() throws Exception{
        //(-1;-0.5)
        testPoint(-0.74);
    }
    @Test
    public void testSecond3() throws Exception{
        //(-1;-0.5)
        testPoint(-0.58);
    }
    @Test
    public void testThird1() throws Exception{
        //(-0.5;0)
        testPoint(-0.43);
    }
    @Test
    public void testThird2() throws Exception{
        //(-0.5;0)
        testPoint(-0.25);
    }
    @Test
    public void testThird3() throws Exception{
        //(-0.5;0)
        testPoint(-0.05);
    }
    @Test
    public void testFourth1() throws Exception{
        //(0;0.5)
        testPoint(0.14);
    }
    @Test
    public void testFourth2() throws Exception{
        //(0;0.5)
        testPoint(0.27);
    }
    @Test
    public void testFourth3() throws Exception{
        //(0;0.5)
        testPoint(0.47);
    }
    @Test
    public void testFifth1() throws Exception{
        //(0.5;1)
        testPoint(0.7);
    }
    @Test
    public void testFifth2() throws Exception{
        //(0.5;1)
        testPoint(0.81);
    }
    @Test
    public void testFifth3() throws Exception{
        //(0.5;1)
        testPoint(0.98);
    }
    @Test
    public void testSixth1() throws Exception{
        //(1;+oo)
        testPoint(+124333.2);
    }
    @Test
    public void testSixth2() throws Exception{
        //(1;+oo)
        testPoint(26582.954);
    }
    @Test
    public void testSixth3() throws Exception{
        //(1;+oo)
        testPoint(1.2323);
    }
    @Test
    public void testMinusOne() throws Exception {
        testPoint(-1);
    }
    @Test
    public void testMinusHalf() throws Exception {
        testPoint(-0.5);
    }
    @Test
    public void testZero() throws Exception {
        testPoint(0);
    }
    @Test
    public void testPlusHalf() throws Exception {
        testPoint(0.5);
    }
    @Test
    public void testPlusOne() throws Exception {
        testPoint(1);
    }
}