package loop;
//번호 이름 국어 영어 수학 점수를 입력받아
//번호:##번 이름: ###
//국어:0##점 영어:0##점 수학 0##점
//총점: ###점 평균 ##.##점
//의 형식으로 출력하는 프로그램
//단, 국영수 점수의 경우에는
//사용자가 잘못된 점수를 입력하면
//올바른 점수가 들어올때까지 다시 입력을 받으시오
import java.util.Scanner;
public class While04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("번호를 입력하세요: ");
        int number = scanner.nextInt();
        System.out.print("이름을 입력하세요: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.printf("국어점수를 입력하세요:");
        int korean=scanner.nextInt();
        while(korean<0 || korean>100) {
            System.out.printf("잘못 입력하셨습니다. \n국어점수를 입력하세요: ");
            korean=scanner.nextInt();
        }
        System.out.printf("영어점수를 입력하세요:");
        int english=scanner.nextInt();
        while(english<0 || english>100) {
            System.out.printf("잘못 입력하셨습니다. \n영어점수를 입력하세요: ");
            english=scanner.nextInt();
        }
        System.out.printf("수학점수를 입력하세요:");
        int math=scanner.nextInt();
        while(math<0 || math>100) {
            System.out.printf("잘못 입력하셨습니다. \n수학점수를 입력하세요: ");
            math=scanner.nextInt();
        }
        
        int total=korean+english+math;
        float avr=(float)total/3;
        
        System.out.printf("번호:%d번 이름:%s\n",number,name);
        System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",korean,english,math);
        System.out.printf("총점:%3d점 평균:%.2f점",total,avr);
        
        scanner.close();
    }
}
