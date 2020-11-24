package loop;
//숫자 맞추기 게임
//컴퓨터가 임의로 만든 숫자(=난수)를
//사용자가 알아맞추는 게임.
//사용자가 입력한 숫자가 컴퓨터 난수보다 크면 DOWN
//작으면 UP
//또한 사용자의 최고기록을 보관해서
//만약 메뉴에서 최고기록 보기를 하면
//해당 최고기록을 볼수있게한다.
import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
    final static int MAX=100;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        int bestScore = 0;
        
        while(true) {
            System.out.println("1. 플레이 2. 최고기록 보기 3. 종료");
            System.out.print(" >");
            int choice=scan.nextInt();
            if(choice==1) {
                //랜덤 클래스 변수를 사용할 때에는
                //필요한 난수의 데이터타입에 맞추어
                //next~~~ 메소드를 실행하면된다.
                //메소드()안에 숫자를 집어넣으면
                //0부터 그 숫자-1사이의 난수가 생성된다.
                //만약 아무런 숫자도 넣어주지 않으면
                //해당 데이터타입의 범위내에서 정해지게 된다.
                int computerNumber=random.nextInt(MAX)+1;
                //사용자가 입력할 숫자
                int userNumber=0;
                //이번 라운드 사용자 점수
                int score=0;
                while(computerNumber!=userNumber) {
                    System.out.print("숫자 입력: ");
                    userNumber=scan.nextInt();
                    
                    if(userNumber>computerNumber)
                        System.out.println("DOWN");
                    else if(userNumber<computerNumber)
                        System.out.println("UP");
                    score++;
                }
                
                System.out.println("정답!");
                System.out.printf("총 %d회만에 맞추셨습니다.\n",score);
                if(bestScore==0||score<bestScore) {
                    System.out.println("최고기록 갱신!");
                    bestScore=score;
                }
                    bestScore=score;
            }else if(choice==2) {
                if(bestScore==0) 
                    System.out.println("아직 플레이한 기록이 없습니다.");
                else 
                    System.out.println("현재 최고 기록은 "+bestScore+"회입니다.");
            }else if(choice==3) {
                System.out.println("플레이해주셔서 감사합니다.");
                break;
            }else 
                System.out.println("잘못 입력하셨습니다.");
        }
        
        scan.close();
    }

}
