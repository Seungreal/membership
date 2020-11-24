package array;
//동적할당을 이용하여

//원하는 만큼의 학생을 관리가능한
//성적관리 프로그램

import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

public class GradeBook03 {
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        showMenu(scan);

        scan.close();
    }

    private static void showMenu(Scanner scan) {
        Student[] array = new Student[0];
        while (true) {
            System.out.println("비트고등학교 성적관리프로그램");
            System.out.println("1.입력");
            System.out.println("2.성적 출력");
            System.out.println("3.종료");
            int userChoice = ScannerUtil.nextInt(scan, ">", 1, 3);
            if (userChoice == 1) {
                array = insert(scan, array);
            } else if (userChoice == 2) {
                array = printAll(scan, array);
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private static Student[] insert(Scanner scan, Student[] studentArray) {
        if (ArrayUtil.size(studentArray) < MAX_SIZE) {
            Student s = new Student();

            System.out.print("번호: ");
            s.setId(scan.nextInt());
            System.out.print("이름: ");
            s.setName(ScannerUtil.nextLine(scan));
            s.setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
            s.setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
            s.setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));

            studentArray = ArrayUtil.add(studentArray, s);
        } else {
            System.out.println("관리 명단의 목록이 꽉 찼습니다.");
        }

        return studentArray;
    }

    private static Student[] printAll(Scanner scan, Student[] studentArray) {
        if (ArrayUtil.size(studentArray) == 0)
            System.out.println("아직 입력된 학생이 없습니다.");
        else {
            for (int i = 0; i < studentArray.length; i++) {
                System.out.printf("%d. %s\n", i + 1, studentArray[i].getName());
            }
            int userChoice = ScannerUtil.nextInt(scan, "출력할 번호의 학생을 선택해주세요(0은 뒤로가기): ",0, studentArray.length) - 1;
            if (userChoice != -1) {
                studentArray=selectOne(scan,studentArray,userChoice);
            }

        }
        return studentArray;
    }

    // 객체 개별보기+수정삭제시 관련메소드 호출
    private static Student[] selectOne(Scanner scan, Student[] studentArray, int index) {
        Student s = studentArray[index];
        
        System.out.println("---------------");
        System.out.printf("번호: %d, 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n", 
                s.getKorean(), s.getEnglish(),s.getMath());
        System.out.printf("총점: %03d점, 평균:%.2f점\n", s.calculateSum(), s.calculateAvr());
        System.out.println("---------------");
        
        int userChoice = ScannerUtil.nextInt(scan, "1.수정 2.삭제 3.뒤로가기 >", 1, 3);
        
        if(userChoice==1) {
            updateStudent(scan,s);
            studentArray=selectOne(scan,studentArray,index);
        }else if(userChoice==2) {
            studentArray=deleteStudent(scan,studentArray,index);
            printAll(scan,studentArray);
        }

        return studentArray;
    }
    
    private static void updateStudent(Scanner scan, Student s) {
        System.out.println("수정");
        System.out.println("번호: "+s.getId()+"번");
        System.out.println("이름: "+s.getName());
        s.setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
        s.setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
        s.setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
    }
    
    private static Student[] deleteStudent(Scanner scan,Student[] studentArray,int index) {
        System.out.print("해당 학생을 정말 삭제하시겠습니까? y/n: ");
        String agree = ScannerUtil.nextLine(scan);
        if(agree.equals("y")) {
            studentArray = ArrayUtil.removeByIndex(studentArray, index);
        }
        
        return studentArray;
    }
}
