package array;
//Stutent 데이터타입에 직접 값을 넣고 출력하는 프로그램

import java.util.Scanner;

import util.ScannerUtil;

public class Struct01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student s = new Student();
        System.out.print("번호:");
        s.setId(scan.nextInt());
        System.out.print("이름:");
        s.setName(ScannerUtil.nextLine(scan));
        s.setKorean(ScannerUtil.nextInt(scan, "국어:", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scan, "영어:", 0, 100));
        s.setMath(ScannerUtil.nextInt(scan, "수학:", 0, 100));

        System.out.printf("번호: %d, 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", s.getKorean(), s.getEnglish(), s.getMath());
        System.out.printf("총점: %03d점, 평균:%.2fd점\n",s.calculateSum(),s.calculateAvr());

        scan.close();
    }
}
