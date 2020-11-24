package loop;
//계산기의 기능을 구현해서
//계산기를 만들어보자
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int sum = add(3,4);
        System.out.println("add(3,4): "+sum);
        System.out.println("sub(3,4): "+sub(3,4));
        System.out.println("mul(3,4): "+mul(3,4));
        System.out.println("div(3,4): "+div(3,4));
        
        scan.close();
    }
    
    //add메소드
    static int add(int a,int b) {
        return a+b;
    }
    
    //sub메소드
    static int sub(int a,int b) {
        return a-b;
    }
    
    //mul메소드
    static int mul(int a,int b) {
        return a*b;
    }
    
    //div메소드
    static float div(int a,int b) {
        return (float)a/b;
    }
}
