package loop;

public class Calculator02 {

    public static void main(String[] args) {
        System.out.println(div(3,4));
    }
    static int add(int a,int b) {
        return a+b;
    }
    static double add(double a,double b) {
        return a+b;
    }
    
    static int sub(int a,int b) {
        return a-b;
    }
    static double sub(double a,double b) {
        return a-b;
    }
    
    static int mul(int a,int b) {
        return a*b;
    }
    static double mul(double a,double b) {
        return a*b;
    }
    
    static double div(int a,int b) {
        return (double)a/b;
    }
    static double div(double a,double b) {
        return a/b;
    }

}
