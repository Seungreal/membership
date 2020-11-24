package branch;
//숫자를 입력바다
//홀수일때만 "홀수입니다"를 출력하는 프로그램
//단 짝수일때는 아무런 반응이 없음
import java.util.Scanner;
public class If02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("숫자를 입력하세요: ");
        int number = scanner.nextInt();
        
        if(number%2==1) {
            System.out.println("홀수입니다.");
        }
        
        scanner.close();

    }

}
