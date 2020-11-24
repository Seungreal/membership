package loop;
//의도적으로 무한루프를 만들어
//원하는 프로그램을 만들수 있다.
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            System.out.println("----------------------");
            System.out.println("비트 고등학교 성적관리 프로그램");
            System.out.println("----------------------");
            System.out.println("       1. 입력");
            System.out.println("       2. 출력");
            System.out.println("       3. 종료");
            System.out.print("> ");
            int userChoice = scan.nextInt();
            if(userChoice==1) {
                
            }
            else if(userChoice==2) {
                
            }
            else if(userChoice==3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
            else {
                System.out.println("잘못 선택하셨습니다.");
            }
        }
        
        scan.close();
    }
}
