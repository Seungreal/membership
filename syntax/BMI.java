package syntax;
//키와 몸무게를 입력받아서 BMI를 계산하여
//출력하는 프로그램을 작성
//BMI는 몸무게/키/키
import java.util.Scanner;
public class BMI {
    static final int CM_M = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("키를 입력하세요:");
        int height_c = scanner.nextInt();
        float height = (float)height_c/CM_M;
        System.out.printf("몸무게를 입력하세요:");
        int weight = scanner.nextInt();
        float bmi = (weight / height) / height;
        System.out.printf("BMI는 %.2f입니다",bmi);
        
        
        scanner.close();
    }

}
