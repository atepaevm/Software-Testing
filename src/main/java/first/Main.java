package first;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Calculation calc=new Calculation();
        for(double i=-1;i<=1;i+=0.00001)
            if(Math.asin(1)-calc.arcsin(1)>-1)
                System.out.println(Math.asin(1)-calc.arcsin(1));
    }
}
