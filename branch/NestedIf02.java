package branch;
//번호,이름,국영수 점수를 입력받아서
//번호:##번,이름: ###
//국어:0##점 영어:0##점 수학:0##점
//총점:0##점 평균:##.##점
//이 출력되는 프로그램
//단 잘못된 국영수점수를 입력하면
//"잘못 입력하셨습니다. 종료하겠습니다."가 출력이 되고
//모든 점수를 올바르게 입력할때만
//위의 정보가 출력되게 프로그램 작성
import java.util.Scanner;
public class NestedIf02 {
    static final int SUBJECT_SIZE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("번호를 입력하세요:");
        int number=scanner.nextInt();
        
        System.out.printf("이름를 입력하세요:");
        scanner.nextLine();
        String name=scanner.nextLine();
        
        System.out.printf("국어점수를 입력하세요:");
        int korean=scanner.nextInt();
        
        if(korean<=100&&korean>=0) {
            System.out.printf("영어점수를 입력하세요:");
            int english=scanner.nextInt();
            
            if(english<=100&&english>=0) {
                System.out.printf("수학점수를 입력하세요:");
                int math=scanner.nextInt();
                    
                if(math<=100&&math>=0) {
        
                int total=korean+english+math;
                float avr=(float)total/SUBJECT_SIZE;
        
                System.out.printf("번호:%d번 이름:%s\n",number,name);
                System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",korean,english,math);
                System.out.printf("총점:%3d점 평균:%.2f점",total,avr);
                }
                else
                    System.out.println("잘못 입력하셨습니다. 종료하겠습니다.");
            }
            else
                System.out.println("잘못 입력하셨습니다. 종료하겠습니다.");
        }
        else
            System.out.println("잘못 입력하셨습니다. 종료하겠습니다.");
        
        
        scanner.close();

    }

}
