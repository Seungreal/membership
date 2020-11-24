package loop;

import java.util.Scanner;
public class PrintStar10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------");
        System.out.println("별찍기 10번");
        System.out.println("-------");
        System.out.print("출력할 줄수: ");
        int userNumber = scanner.nextInt();
        
        /*for(int i=1;i<=userNumber;i++) {
            String stars = new String();
            for(int j=0;j<=userNumber-i;j++) {
                stars+="*";
            }
            for(int j=3;j<i*2;j++) {
                stars+=" ";
            }
            if(i==1) {
                for(int j=1;j<=userNumber-i;j++) {
                    stars+="*";
                }
            }
            else {
                for(int j=0;j<=userNumber-i;j++) {
                    stars+="*";
                }
            }
            System.out.println(stars);
        }
        for(int i=userNumber-1;i>0;i--) {
            String stars = new String();
            for(int j=0;j<=userNumber-i;j++) {
                stars+="*";
            }
            for(int j=3;j<i*2;j++) {
                stars+=" ";
            }
            if(i==1) {
                for(int j=1;j<=userNumber-i;j++) {
                    stars+="*";
                }
            }
            else {
                for(int j=0;j<=userNumber-i;j++) {
                    stars+="*";
                }
            }
            System.out.println(stars);
        }*/
        for(int i=1;i<2*userNumber;i++) {
            String stars = new String();
            int controlI;
            if(i<=userNumber) {
                controlI=i;
            }
            else {
                controlI=2*userNumber-i;
            }
            if(controlI==1) {
                for(int j=1;j<2*userNumber;j++) {
                    stars+="*";
                }
            }
            else {
                for(int j=controlI;j<=userNumber;j++) {
                    stars+="*";
                }
                int upperI = controlI-1;
                for(int j=1;j<2*upperI;j++) {
                    stars+=" ";
                }
                for(int j=controlI;j<=userNumber;j++) {
                    stars+="*";
                }
            }

            System.out.println(stars);
        }
               
        scanner.close();
    }
}