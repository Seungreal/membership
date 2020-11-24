package syntax;
// Scanner
import java.util.Scanner;
public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. 정수 입력
        System.out.print("숫자: ");
        int number = scanner.nextInt();
        System.out.println("number의 현재값: "+number);
        
        //2. 실수 입력
        System.out.print("실수: ");
        double myDouble = scanner.nextDouble();
        System.out.println("myDouble의 현재값: "+myDouble);
        
        //3. 스트링 입력
        //   주의점
        //   nextint,nextdouble 이후에 바로 사용X
        System.out.print("이름: ");
        //스캐너 버그 해결을 위한 scanner.nextLine() 실행
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("name의 현재값: "+name);
        
        
        scanner.close();
    }

}
