package board;

import java.util.Scanner;

import util.ScannerUtil;

public class NextIntTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("숫자: ");
        int number = ScannerUtil.nextInt(scan,"숫자: ",0,100);
        System.out.println("number: "+number);
        
        scan.close();
    }
}
