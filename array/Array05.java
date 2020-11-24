package array;

import java.util.Scanner;

import util.ScannerUtil;

//1~5반의 학생수를 받고
//그 학생들의 시험점수(0~100)을 받는 프로그
//입력이 다 끝난 후에는
//----1반----
//1번:##점
//2번:##점
//.....
//----------
//1번:##점
//.....
public class Array05 {
    private static final int CLASS_SIZE = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] scoreArray = new int[CLASS_SIZE][];

        for (int i = 0; i < CLASS_SIZE; i++) {
            System.out.printf("%d반 학생의 수: ", i + 1);
            int classSize = scan.nextInt();
            scoreArray[i] = new int[classSize];
        }

        for (int i = 0; i < CLASS_SIZE; i++) {
            for (int j = 0; j < scoreArray[i].length; j++) {
                String message = (i + 1) + "반 " + (j + 1) + "번 학생의 점수: ";
                scoreArray[i][j] = ScannerUtil.nextInt(scan, message, 0, 100);
            }
        }

        for (int i = 0; i < CLASS_SIZE; i++) {
            System.out.println("-----" + (i + 1) + "반-----");
            for (int j = 0; j < scoreArray[i].length; j++) {
                System.out.println((j + 1) + "번:" + scoreArray[i][j] + "점");
            }
            System.out.println("-------------");
        }

        scan.close();
    }
}
