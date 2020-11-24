package array;

import java.util.Scanner;

import util.ScannerUtil;

public class GradeBook02 {
    private static final int STUDENT_SIZE = 3;
    private static final int SUBJECT_SIZE = 3;
    private static final int SCORE_MAX = 100;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] idArray = new int[STUDENT_SIZE];
        String[] nameArray = new String[STUDENT_SIZE];
        int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];

        for (int i = 0; i < STUDENT_SIZE; i++) {
            System.out.printf("번호를 입력하세요.\n>");
            idArray[i] = scan.nextInt();

            System.out.printf("이름을 입력하세요.\n>");
            nameArray[i] = ScannerUtil.nextLine(scan);

            scoreArray[i][0] = ScannerUtil.nextInt(scan, (i + 1) + "번 학생의 국어점수: ", 0, SCORE_MAX);
            scoreArray[i][1] = ScannerUtil.nextInt(scan, (i + 1) + "번 학생의 영어점수: ", 0, SCORE_MAX);
            scoreArray[i][2] = ScannerUtil.nextInt(scan, (i + 1) + "번 학생의 수학점수: ", 0, SCORE_MAX);
        }

        for (int i = 0; i < STUDENT_SIZE; i++) {
            System.out.println(idArray[i] + "번 " + nameArray[i]);
            int sum = 0;
            for (int j = 0; j < SUBJECT_SIZE; j++) {
                sum += scoreArray[i][j];
            }
            double avr = sum / (double) SUBJECT_SIZE;
            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", 
                    scoreArray[i][0], scoreArray[i][1], scoreArray[i][2]);
            System.out.printf("총점: %03d점 평균: %.2f점\n", sum, avr);
            System.out.println("------------------------------");
        }

        scan.close();
    }
}
