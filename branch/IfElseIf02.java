package branch;
//점수를 입력받아
//90점이상:A
//80점이상:B
//70점이상:C
//60점이상:D
//그외:F
//가 출력되는 프로그램
import java.util.Scanner;
public class IfElseIf02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("점수를 입력하세요: ");
        int score = scanner.nextInt();

        System.out.println("점수 검증이 안된 if else 구조");
        if(score>=90) {
            System.out.println("A");
        }
        else if(score>=80) {
            System.out.println("B");
        }
        else if(score>=70) {
            System.out.println("C");
        }
        else if(score>=60) {
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }
        
        System.out.println("-----------------");
        System.out.println("2.범위를 빡빡하게 잡자");
        System.out.println("-----------------");
        if(score>=90&&score<=100) {
            System.out.println("A");
        }
        else if(score>=80&&score<=89) {
            System.out.println("B");
        }
        else if(score>=70&&score<=79) {
            System.out.println("C");
        }
        else if(score>=60&&score<=69) {
            System.out.println("D");
        }
        else if(score>=0&&score<=59){
            System.out.println("F");
        }
        else {
            System.out.println("잘못 입력하셨습니다.");
        }
        
        System.out.println("-----------------");
        System.out.println("3.점수가 올바를때만 실행");
        System.out.println("-----------------");
        
        if(score>=0 && score <=100) {
            if(score>=90) {
                System.out.println("A");
            }
            else if(score>=80) {
                System.out.println("B");
            }
            else if(score>=70) {
                System.out.println("C");
            }
            else if(score>=60) {
                System.out.println("D");
            }
            else {
                System.out.println("F");
            }
        }
        else {
            System.out.println("잘못 입력하셨습니다.");
        }
        
        scanner.close();
    }

}
