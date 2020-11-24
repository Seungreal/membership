package loop;

import java.util.Scanner;
public class PrintStar09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 9번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        /*for(int i=1;i<=userNumber;i++) {
            String stars = new String();
            for(int j=0;j<userNumber-i;j++) {
                stars+=" ";
            }
            for(int j=1;j<i*2;j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
        for(int i=userNumber-1;i>=1;i--) {
            String stars = new String();
            for(int j=1;j<=userNumber-i;j++) {
                stars+=" ";
            }
            for(int j=1;j<i*2;j++) {
                stars+="*";
            }
            System.out.println(stars);          
        }*/
        
        for(int i=1;i<2*userNumber;i++) {
            String stars = new String();
            int controlI=0;
            if(i<=userNumber) {
                controlI=i;
            }
            else {
                controlI=2*userNumber-i;
            }
            for(int j=1;j<=userNumber-controlI;j++) {
                stars+=" ";
            }
            for(int j=1;j<2*controlI;j++) {
                stars+="*";
            }
            System.out.println(stars);          
        }
        
        scanner.close();
    }
}
