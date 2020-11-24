package array;

import java.util.Scanner;

import util.ScannerUtil;

public class Array02 {
    private static final int SIZE = 3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] scoreArray = new int[SIZE];
        for(int i=0; i < scoreArray.length; i++) {
            scoreArray[i] = ScannerUtil.nextInt(scan, (i+1)+"번 시험점수: ", 1, 100);
        }
        
        int sum=0;
        for(int i=0; i < scoreArray.length; i++) {
            sum+=scoreArray[i];
        }
        double avr=sum/(double)SIZE;
        System.out.printf("총점: %03d점 평균: %.2f점\n",sum,avr);
        scan.close();
    }
}
