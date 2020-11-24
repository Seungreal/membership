package array;

import java.util.Scanner;

import util.ScannerUtil;

//국영수 점수를 입력받아
//1~3회차의 점수와 총점 평균을 출력하는 프로그램
//1번 ㅇㅇㅇ
//---1번 시험---
//국어:000점 영어:000점 수학:000점
//총점:000점 평균:00.00점
//------------
//---2번 시험---
//...
//---3번 시험---
//...

public class Array03 {
    private static final int SCORE_MAX = 100;
    private static final int SIZE = 3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id=0;
        String name = new String();
        int[] koreanArray = new int[SIZE];
        int[] englishArray = new int[SIZE];
        int[] mathArray = new int[SIZE];
  
        System.out.printf("번호를 입력하세요.\n>");
        id=scan.nextInt();
        System.out.printf("이름을 입력하세요.\n>");
        name=ScannerUtil.nextLine(scan);
  
        for(int i=0; i < SIZE; i++) {
            koreanArray[i]=ScannerUtil.nextInt(scan, "국어 "+(i+1)+"회차 점수: ", 0, SCORE_MAX);
            englishArray[i]=ScannerUtil.nextInt(scan, "영어 "+(i+1)+"회차 점수: ", 0, SCORE_MAX);
            mathArray[i]=ScannerUtil.nextInt(scan, "수학 "+(i+1)+"회차 점수: ", 0, SCORE_MAX);
        }
        
        System.out.println(id+"번 "+name);
        for(int i=0; i < SIZE; i++) {
            int sum = koreanArray[i]+englishArray[i]+mathArray[i];
            double avr = sum / (double)SIZE;
            System.out.println("-------"+(i+1)+"회차 시험-------");
            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n",
                    koreanArray[i],englishArray[i],mathArray[i]);
            System.out.printf("총점: %03d점 평균: %.2f점\n",sum,avr);
            System.out.println("------------------------------");
        }
  
        scan.close();
    }
}
