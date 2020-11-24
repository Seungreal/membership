package loop;
//가위바위보 게임
//메뉴: 1.플레이 2.전적보기 3. 종료
//1. 플레이시에는
//   사용자가 가위바위보 중에 하나를 고르게 한다.
//   단 가위는1,바위는2,보는3이고
//   만약 잘못된 값을 입력하면 다시 입력하게 한다.
//   컴퓨터도 마찬가지로 1~3사이의 난수를 만들어서
//   사용자의 입력값과 비교해서
//   사용자 기준으로 승리,무승부,패배 3가지 중 하나를 기록한다.
//2. 전적보기시에는
//   ###전 ###승 ###무 ###패 식으로 출력되게 한다.
//   단 아무런 플레이 기록도 없을 경우에는
//   "아직 플레이한 기록이 없습니다."가 출력
import java.util.Random;
import java.util.Scanner;
public class RCP {
   final static int MAX=3;
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       Random random = new Random();
       
       int count=0,win=0,tie=0,lose=0;
       
       while(true) {
           System.out.println("1.플레이 2.전적보기 3.종료");
           System.out.print(">");
           int choice=scan.nextInt();
           if(choice==1) {
               int computerNumber=random.nextInt(MAX)+1;
               System.out.println("무엇을 내시겠습니까?(가위1,바위2,보3)");
               System.out.print(">");
               int userNumber=scan.nextInt();
               while(!(userNumber==1||userNumber==2||userNumber==3)) {
                   System.out.println("잘못입력하셨습니다. 무엇을 내시겠습니까?(가위1,바위2,보3)");
                   System.out.print(">");
                   userNumber=scan.nextInt();
               }
               String userRCP = rcpSetter(userNumber);
               String computerRCP = rcpSetter(computerNumber);
                       
               System.out.println("사용자는 "+userRCP+". 컴퓨터는 "+computerRCP);
               if(computerNumber==userNumber) {
                   System.out.println("무승부입니다.");
                   tie++;
               }
               else {
                   if(userNumber==1) {
                       if(computerNumber==2) {
                           System.out.println("졌습니다.");
                           lose++;
                       }
                       else {
                           System.out.println("이겼습니다!");
                           win++;
                       }
                   }
                   else if(userNumber==2) {
                       if(computerNumber==3) {
                           System.out.println("졌습니다.");
                           lose++;
                       }
                       else {
                           System.out.println("이겼습니다!");
                           win++;
                       }
                   }
                   else if(userNumber==3) {
                       if(computerNumber==1) {
                           System.out.println("졌습니다.");
                           lose++;
                       }
                       else {
                           System.out.println("이겼습니다!");
                           win++;
                       }
                   }
               }
               count++;
               
//               if((computerNumber==1&&userNumber==2)||(computerNumber==2&&userNumber==3)||(computerNumber==3&&userNumber==1)) {
//                   System.out.println("이겼습니다!");
//                   win++;
//               }else if((computerNumber==1&&userNumber==3)||(computerNumber==2&&userNumber==1)||(computerNumber==3&&userNumber==2)) {
//                   System.out.println("졌습니다.");
//                   lose++;
//               }else if((computerNumber==1&&userNumber==1)||(computerNumber==2&&userNumber==2)||(computerNumber==3&&userNumber==3)) {
//                   System.out.println("무승부입니다.");
//                   tie++;
//               }
//               count++;
           }               
           else if(choice==2) {
               if(count==0)
                   System.out.println("아직 플레이한 기록이 없습니다.");
               else
                   System.out.printf("%03d전 %03d승 %03d무 %03d패\n",count,win,tie,lose);
           }
           else if(choice==3){
               System.out.println("종료합니다.");
               break;
           }
           else
               System.out.println("잘못 입력하셨습니다.");
       }
       
       scan.close();
    }
   
   static String rcpSetter(int value) {
       switch(value) {
       case 1:
           return "가위";
       case 2:
           return "바위";
       case 3:
           return "보";
       default:
           return "";
               
       }
   }

}
