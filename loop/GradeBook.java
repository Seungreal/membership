package loop;
//번호 이름 국어 영어 수학 점수를 입력받아서
//번호:##번 이름: ###
//국어:0##점 영어:0##점 수학 0##점
//총점: ###점 평균 ##.##점
//의 형식으로 출력하는 프로그램
//단, 국영수 점수의 경우
//사용자가 잘못된 점수를 입력하면
//올바른 점수가 들어올때까지 다시 입력을 받게
//또한 처음 프로그램을 시작할 때
//사용자가 입력,출력,종료를 선택하여
//원하는 횟수만큼 입력하고 출력할수 있게 프로그램 작성
import java.util.Scanner;
public class GradeBook {
    public static int SUBZECT_SIZE=3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number=0;
        String name=new String();
        int korean=-1,english=0,math=0;
        
        while(true) {
            System.out.println("1. 입력 2. 출력 3.종료");
            System.out.print("> ");
            int userChoice = scan.nextInt();
            if(userChoice==1) {
                System.out.print("번호: ");
                number=scan.nextInt();
                
                System.out.print("이름: ");
                scan.nextLine();
                name=scan.nextLine();
                
                System.out.print("국어: ");
                korean=scan.nextInt();
                while(korean<0 || korean>100) {
                    System.out.printf("잘못 입력하였음.\n국어: ");
                    korean=scan.nextInt();
                }
                
                System.out.print("영어: ");
                english=scan.nextInt();
                while(english<0 || english>100) {
                    System.out.printf("잘못 입력하였음.\n영어: ");
                    english=scan.nextInt();
                }
                
                System.out.print("수학: ");
                math=scan.nextInt();
                while(math<0 || math>100) {
                    System.out.printf("잘못 입력하였음.\n수학: ");
                    math=scan.nextInt();
                }
            }else if(userChoice==2) {
                if(korean==-1) {
                    System.out.println("아직 아무런 정보도 입력되지 않았음");
                }else {
                    int total=korean+english+math;
                    float avr=(float)total/SUBZECT_SIZE;
                
                    System.out.printf("번호:%d번 이름:%s\n",number,name);
                    System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",korean,english,math);
                    System.out.printf("총점:%3d점 평균:%.2f점\n",total,avr);
                }
            }else if(userChoice==3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }else {
                System.out.println("잘못 선택하셨습니다.");
            }
        }
        
        scan.close();
    }
}
