package first;

import second.HashEntry;
import second.HashMap;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Calculation calc=new Calculation();
        System.out.println(calc.arcsin(0.5));
        //for(double i=-1;i<=1;i+=0.00001)
         //   if(Math.asin(1)-calc.arcsin(1)>0)
        //        System.out.println(Math.asin(1)-calc.arcsin(1));

        HashMap map=new HashMap();
        map.put(0,"0");
        map.put(0,"0");
        map.remove(0);
        map.showTable();

    }
}
