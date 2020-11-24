package loop;

import java.util.Scanner;
public class PrintStar07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 7번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        for(int i=1;i<=userNumber;i++) {
            String stars = new String();
            for(int j=1;j<=i;j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
        for(int i=userNumber-1;i>=1;i--) {
            String stars = new String();
            for(int j=1;j<=i;j++) {
                stars+="*";
            }
            System.out.println(stars);          
        }
        
        scanner.close();
    }
}
