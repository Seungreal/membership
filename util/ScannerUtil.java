package util;

import java.util.Scanner;

//입력과 관련된 여러 유용한 메소드를 구현해놓은
//ScannerUtil 클래스
public class ScannerUtil {
    //1. nextint()후에 nextLine()사용시
    //   버퍼메모리를 알아서 비워서 nextLine을 실행해주는 메소드
    public static String nextLine(Scanner scanner) {
        //먼저 nextLine등 때문에
        //다음줄 엔터키가 존재하는지 체크하기 위해서
        //String temp = Scanner.nextLine() 실행
        //그후 temp.equals("")이 트루가 나오면
        //temp=Scanner.nextLine() 다시 실행
        //가장 마지막에 return temp
        String temp = scanner.nextLine();
        if(temp.isEmpty()) {
            temp = scanner.nextLine();
        }
        
        return temp;
    }
    
    //입력한 값이 숫자로만 이루어져 있으면 int로 변환하고
    //만약 숫자로만 이루어져있지 않은 경우에는
    //숫자만 입력할 때까지 계속 입력을 요구하는 nextInt메소드
    public static int nextInt(Scanner scan) {
        String temp = nextLine(scan);
        //temp가 숫자로만 이루어져있는지 확인한다
        //만약 그러지 않을 경우
        //temp가 숫자로만 이루어질때까지
        //계속 입력을 다시 받는다
        while(!temp.matches("\\d*")) {
            System.out.print("숫자만 입력해주세요.\n>");
            temp = nextLine(scan);
        }
        //String을 숫자로 바꿀 대에는
        //Integer 클래스의 parseInt()메소드를 실행하면되는데
        //해당 메소드는 static 설정이 되어있으므로
        //객체선언은 필요없다
        
        return Integer.parseInt(temp);
    }
    
    //입력을 받을때 사용자가 원하는 스트링 값을 보여주고 입력을 받는
    //nextInt() 메소드
    public static int nextInt(Scanner scanner,String message,int min,int max) {
        System.out.println(message);
        System.out.print(">");
        int temp = nextInt(scanner);
        
        while(temp<min||temp>max) {
            System.out.print("잘못 입력하셨습니다.\n>");
            System.out.print(message);
            temp = nextInt(scanner);
        }
        
        return temp;
    }

}
