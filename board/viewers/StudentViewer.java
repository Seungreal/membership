package board.viewers;
//학생부여를
//필드안에
//스캐너와 배열을 활용해서
//BoardViewer처럼 만들기

import java.util.Scanner;

import array.Student;
import util.ArrayUtil;
import util.ScannerUtil;

public class StudentViewer {
    private Scanner scan;
    private Student[] sArray;
    
    public StudentViewer() {
        scan=new Scanner(System.in);
        sArray=new Student[0];
    }
    
    public void showMenu() {
        while (true) {
            System.out.println("성적관리프로그램");
            String message = "1.입력 2.성적출력 3.종료\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
    
    private void insert() {
        Student s = new Student();

        System.out.print("번호: ");
        s.setId(scan.nextInt());
        System.out.print("이름: ");
        s.setName(ScannerUtil.nextLine(scan));
        s.setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
        
        sArray = ArrayUtil.add(sArray, s);
    }
    
    private void printAll() {
        if (sArray.length == 0) {
            System.out.println("아직 입력된 학생이 없습니다.");
        } else {
            for (int i = 0; i < sArray.length; i++)
                System.out.printf("%d. %s\n", i + 1, sArray[i].getName());

            String message = "출력할 번호의 학생을 선택해주세요(0은 뒤로가기)\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 0, sArray.length) - 1;

            if (userChoice != -1) {
                selectOne(userChoice);
            }
        }
    }
    
    private void selectOne(int index) {
        Student s = sArray[index];
        
        System.out.println("---------------");
        System.out.printf("번호: %d, 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", 
                s.getKorean(), s.getEnglish(),s.getMath());
        System.out.printf("총점: %03d점, 평균:%.2f점\n", s.calculateSum(), s.calculateAvr());
        System.out.println("---------------");
        
        String message = "1.수정 2.삭제 3.뒤로가기\n>";
        int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
        if(userChoice==1) {
            updateStudent(index);
            selectOne(index);
        }else if(userChoice==2) {
            deleteStudent(index);
            printAll();
        }else if(userChoice==3) {
            printAll();
        }
    }
    
    private void updateStudent(int index) {
        System.out.println("번호: "+sArray[index].getId()+"번");
        System.out.println("이름: "+sArray[index].getName());
        sArray[index].setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
        sArray[index].setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
        sArray[index].setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
    }
    
    private void deleteStudent(int index) {
        System.out.println("정말로 삭제하시겠습니까?y/n");
        String agree = ScannerUtil.nextLine(scan);
        if(agree.equals("y"))
            sArray = ArrayUtil.removeByIndex(sArray,index);
    }
}

