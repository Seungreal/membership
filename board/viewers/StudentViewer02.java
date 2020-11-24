package board.viewers;

import java.util.ArrayList;
import java.util.Scanner;

import array.Student;
import util.ScannerUtil;

public class StudentViewer02 {
    private Scanner scan;
    private ArrayList<Student> list;
    private int id;

    public StudentViewer02() {
        scan = new Scanner(System.in);
        list = new ArrayList<>();
        id = 1;
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

        s.setId(id++);
        System.out.print("이름: ");
        s.setName(ScannerUtil.nextLine(scan));
        s.setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
        
        list.add(s);
    }
    
    private void printAll() {
        if (list.isEmpty()) {
            System.out.println("아직 입력된 학생이 없습니다.");
        } else {
            for (int i = 0; i < list.size(); i++)
                System.out.printf("%d. %s\n", i + 1, list.get(i).getName());

            String message = "출력할 번호의 학생을 선택해주세요(0은 뒤로가기)\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 0, list.size()) - 1;

            if (userChoice != -1) {
                selectOne(userChoice);
            }
        }
    }
    
    private void selectOne(int index) {
        Student s = list.get(index);
        
        s.printInfo();
        
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
        System.out.println("번호: "+list.get(index).getId()+"번");
        System.out.println("이름: "+list.get(index).getName());
        list.get(index).setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
        list.get(index).setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
        list.get(index).setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
    }
    
    private void deleteStudent(int index) {
        System.out.println("정말로 삭제하시겠습니까?y/n");
        String agree = ScannerUtil.nextLine(scan);
        if(agree.toLowerCase().equals("y"))
            list.remove(index);
    }
}
