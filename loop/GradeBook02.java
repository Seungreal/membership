package loop;

import java.util.Scanner;

import util.ScannerUtil;

//Scannerutil을 사용하여
//코드가 좀더 간단해진 형태의
//성적관리 프로그램
public class GradeBook02 {

    static final int SUBZECT_SIZE=3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id =0;
        String name = new String();
        int korean=-1, english=0, math=0;
        while(true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            int userChoice = ScannerUtil.nextInt(scan,">",1,3);
            if(userChoice==1) {
                System.out.print("번호: ");
                id=scan.nextInt();
                
                System.out.print("이름: ");
                name=ScannerUtil.nextLine(scan);
                
                korean=ScannerUtil.nextInt(scan, "국어: ", 0, 100);
                
                english=ScannerUtil.nextInt(scan, "영어: ", 0, 100);
                
                math=ScannerUtil.nextInt(scan, "수학: ", 0, 100);
            }else if(userChoice==2){
                if(korean==-1)
                    System.out.println("아직 입력된 정보가 없습니다.");
                else {
                    int total=korean+english+math;
                    float avr=(float)total/SUBZECT_SIZE;
                
                    System.out.printf("번호:%d번 이름:%s\n",id,name);
                    System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",korean,english,math);
                    System.out.printf("총점:%3d점 평균:%.2f점\n",total,avr);
                }
            }else {
                System.out.println("종료합니다.");
                break;
            }
        }

        scan.close();
    }

}
