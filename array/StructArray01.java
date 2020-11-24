package array;

import java.util.Scanner;

import util.ScannerUtil;

public class StructArray01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student[] studentArray = new Student[5];
        //단 기본형 데이터타입이 아닌 배열의 경우
        //각 요소를 매번 초기화해주어야 정상적으로 사용가능하다.
        
        //에러
        //studentArray[0].id=1;
        
        for(int i=0;i<studentArray.length;i++) {
            studentArray[i]=new Student();
        }
        
        //new라는 키워드는 참조형 데이터타입에 대한
        //공간확보에 쓰이는 키워드이다.

        for(int i=0;i<studentArray.length;i++) {
            System.out.print("번호:");
            studentArray[i].setId(scan.nextInt());
            System.out.print("이름:");
            studentArray[i].setName(ScannerUtil.nextLine(scan));
            studentArray[i].setKorean(ScannerUtil.nextInt(scan, "국어: ", 0, 100));
            studentArray[i].setEnglish(ScannerUtil.nextInt(scan, "영어: ", 0, 100));
            studentArray[i].setMath(ScannerUtil.nextInt(scan, "수학: ", 0, 100));
        }
        
        for(int i=0;i<studentArray.length;i++) {
            System.out.printf("번호: %d, 이름: %s\n", studentArray[i].getId(), studentArray[i].getName());
            System.out.printf("국어: %03d점, 영어: %03d점, 수학: %03d점\n",
                    studentArray[i].getKorean(),studentArray[i].getEnglish(), studentArray[i].getMath());
            System.out.printf("총점: %03d점, 평균:%.2f점\n",studentArray[i].calculateSum(),studentArray[i].calculateAvr());
        }
        
        scan.close();
    }
}
