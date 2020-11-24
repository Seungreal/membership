package array;
//정적할당의 경우
//배열의 크기보다 많은 학생을 입력하고자 할때
//1. 더이상 입력할 수 없습니다.
//2. 가장 앞에 있던 값을 지우고 그 다음 인덱스를 다익고
//   가장 뒷칸에 넣는 방법

import java.util.Scanner;

import util.ScannerUtil;

public class StaticArray01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student[] studentArray = new Student[4];
        
        while(true) {
            System.out.println("비트 학생관리프로그램");
            System.out.println("1.입력 2.출력 3.종료");
            int userChoice = ScannerUtil.nextInt(scan, ">", 1, 3);
            
            if(userChoice==1) {
                //새로운 학생을 입력할 때에는
                //빈 인덱스를 찾고
                //빈 인덱스가 존재하면 입력
                //존재하지 않으면 "모든칸이 찼습니다"
                
                int index=-1;
                for(int i=0;i<studentArray.length;i++) {
                    if(studentArray[i]==null) {
                        index=i;
                        break;
                    }
                }
                if(index==-1) {
                    System.out.println("모든 칸이 다 찼습니다.");
                }else {
                    studentArray[index]=new Student();
                    System.out.print("번호:");
                    studentArray[index].setId(scan.nextInt());
                    System.out.print("이름:");
                    studentArray[index].setName(ScannerUtil.nextLine(scan));
                    studentArray[index].setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
                    studentArray[index].setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
                    studentArray[index].setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
                }
            }else if(userChoice==2) {
                for(int i=0;i<studentArray.length;i++) {
                    if(studentArray[i]!=null) {
                        System.out.printf("번호: %d, 이름: %s\n", studentArray[i].getId(), studentArray[i].getName());
                        System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n",
                                studentArray[i].getKorean(), studentArray[i].getEnglish(), studentArray[i].getMath());
                        System.out.printf("총점: %03d점, 평균:%.2f점\n",studentArray[i].calculateSum(),studentArray[i].calculateAvr());
                    }
                }
            }else if(userChoice==3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        
        scan.close();
    }
}
