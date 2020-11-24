package loop;

import java.util.Scanner;
public class PrintStar08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 8번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        //2개의 for문
        /*for(int i=1;i<=userNumber;i++) {
            String stars = new String();
            for(int j=1;j<=userNumber-i;j++) {
                stars+=" ";
            }
            for(int j=1;j<=i;j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
        for(int i=userNumber-1;i>=1;i--) {
            String stars = new String();
            for(int j=1;j<=userNumber-i;j++) {
                stars+=" ";
            }
            for(int j=1;j<=i;j++) {
                stars+="*";
            }
            System.out.println(stars);          
        }*/
        
        //1개의 for문
        for(int i=1;i<2*userNumber;i++) {
            String stars = new String(); 
            if(i<=userNumber) {
                for(int j=1;j<=userNumber-i;j++) {
                    stars+=" ";
                }
                for(int j=1;j<=i;j++) {
                    stars+="*";
                }
            }
            else {
                int lowerI = i-userNumber;
                for(int j=1;j<=lowerI;j++) {
                    stars+=" ";
                }
                for(int j=1;j<=userNumber-lowerI;j++) {
                    stars+="*";
                }
            }
            System.out.println(stars); 
        }
        
        scanner.close();
    }
}
