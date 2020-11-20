package main;

import java.util.Scanner;

import grade.GradeController;
import grade.GradeDTO;

public class GradeMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GradeController control = new GradeController();
        
        while(true) {
            System.out.println("성적 입출력 시스템");
            System.out.printf("1.성적등록 2.등수발표\n>");
            switch (scan.next()) {
            case "1":
                GradeDTO grade = new GradeDTO();
                System.out.print("이름: ");
                grade.setName(scan.next());
                System.out.print("국어점수: ");
                grade.setKor(scan.nextInt());
                System.out.print("영어점수: ");
                grade.setEng(scan.nextInt());
                System.out.print("수학점수: ");
                grade.setMath(scan.nextInt());
                control.postGrade(grade);
                break;
            case "2":
                GradeDTO[] list = control.getGradeSort();
                for(int i=0;i<list.length;i++) {
                    System.out.println(list[i]);
                }
                break;
            case "0":
                scan.close();
                return;
            }
        }
    }
}
