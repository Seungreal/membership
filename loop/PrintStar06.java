package loop;

import java.util.Scanner;
public class PrintStar06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 6번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        for(int i=userNumber;i>=1;i--) {
            String stars = new String();
            for(int j=0;j<userNumber-i;j++) {
                stars+=" ";
            }
            for(int j=1;j<i*2;j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
        
        scanner.close();
    }
}
