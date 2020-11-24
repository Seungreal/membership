package array;
//사용자로부터 숫자를 입력받아서
//1회차 국영수
//2회차 국영수
//3회차 국영수
//4회차 국영수
//를 입력받는 프로그램

import java.util.Scanner;

import util.ScannerUtil;

public class GradeBook01 {
    private static final int SCORE_MAX = 100;
    private static final int EXAM_SIZE = 4;
    private static final int SUBJECT_SIZE = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id = 0;
        String name = new String();
        int[][] scoreArray = new int[EXAM_SIZE][SUBJECT_SIZE];

        System.out.printf("번호를 입력하세요.\n>");
        id = scan.nextInt();
        System.out.printf("이름을 입력하세요.\n>");
        name = ScannerUtil.nextLine(scan);

        for (int i = 0; i < EXAM_SIZE; i++) {
            System.out.println((i + 1) + "회차 시험");
            scoreArray[i][0] = ScannerUtil.nextInt(scan, "국어점수: ", 0, SCORE_MAX);
            scoreArray[i][1] = ScannerUtil.nextInt(scan, "영어점수: ", 0, SCORE_MAX);
            scoreArray[i][2] = ScannerUtil.nextInt(scan, "수학점수: ", 0, SCORE_MAX);
        }
        System.out.println(id + "번 " + name);
        for (int i = 0; i < EXAM_SIZE; i++) {
            System.out.println("---" + (i + 1) + "회차 시험---");
            int sum = 0;
            for (int j = 0; j < SUBJECT_SIZE; j++) {
                sum += scoreArray[i][j];
            }
            double avr = sum / (double) SUBJECT_SIZE;
            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", scoreArray[i][0], scoreArray[i][1], scoreArray[i][2]);
            System.out.printf("총점: %03d점 평균: %.2f점\n", sum, avr);
        }

        scan.close();
    }
}
