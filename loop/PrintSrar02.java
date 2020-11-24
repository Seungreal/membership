package loop;

import java.util.Scanner;
public class PrintSrar02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 2번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        for(int i=1;i<=userNumber;i++) {
            String stars = new String();
            for(int j=userNumber;j>=i;j--) {
                stars+="*";
            }
            System.out.println(stars);
        }
        
        scanner.close();
    }
}
