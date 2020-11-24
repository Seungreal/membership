package branch;
//이름,국어,영어,수학점수를 입력받아
//총점이 210점 이상이고 모든점수가 60점이상이면
//"###학생님은 합격입니다"가 출력되고
//그외에는 모두 "###학생님은 불합격입니다"가 출력되는 프로그램
import java.util.Scanner;
public class IfElse03 {
    static final int SUM_STANDARD = 210;
    static final int INDIVIDUAL_STANDARD = 60;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("이름를 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("국어점수를 입력하세요: ");
        int korean = scanner.nextInt();
        System.out.print("영어점수를 입력하세요: ");
        int english = scanner.nextInt();
        System.out.print("수학점수를 입력하세요: ");
        int math = scanner.nextInt();
        int sum = korean+english+math;
        
        if(sum>=SUM_STANDARD&&korean>=INDIVIDUAL_STANDARD
                &&english>=INDIVIDUAL_STANDARD
                &&math>=INDIVIDUAL_STANDARD) {
            System.out.printf("%s학생님은 합격입니다.",name);
        }
        else {
            System.out.printf("%s학생님은 불합격입니다.",name);
        }
        
        scanner.close();
    }

}
