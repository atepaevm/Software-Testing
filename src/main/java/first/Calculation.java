package first;

public class Calculation {
    //return factorial of int number
    private int factorial(int n){
        if(n<2)
            return 1;
        return n*factorial(n-1);
    }
    //return power of int number
    private double pow(double base,int power){
        double res=1;
        for(int i=1;i<=power;++i)
            res*=base;
        return res;
    }
    double arcsin(double x){
        if(x<-1||x>1)
            return Double.NaN;
        boolean isNegative=(x<0);
        if(isNegative)
            x=Math.abs(x);
        boolean isGreat=(x>0.71);
        if(isGreat)
            x=Math.sqrt(1-x*x);

        double sum=0;
        double delta=1;
        int step=0;
        while(delta>0.0001){
            delta=1.0*factorial(2*step)/pow(4,step)/factorial(step)/factorial(step)/(2*step+1)*pow(x,2*step+1);
            sum+=delta;
            ++step;
        }
        sum= isGreat ? Math.PI/2-sum:sum;
        return isNegative ? -sum:sum;
    }
}
