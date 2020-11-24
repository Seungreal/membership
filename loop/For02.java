package loop;

import java.util.Scanner;
public class For02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        //1. 1부터 사용자가 입력한 숫자까지를
        //한줄씩 출력하는 for문
        System.out.print("숫자 입력: ");
        number = scanner.nextInt();
        
        for(int i=1;i<=number;i++)
            System.out.println(i+"입니다.");
        
        //2. 1부터 사용자가 입력한 숫자까지의
        //   합을 구하는 for문
        int sum=0;
        System.out.print("숫자 입력: ");
        number = scanner.nextInt();
        
        for(int i=1;i<=number;i++) {
            sum+=i;
        }
        System.out.println("합은 "+sum+"입니다.");
        
        //3. 1부터 사용자가 입력한 숫자까지의
        //   홀수만 출력
        System.out.print("숫자 입력: ");
        number = scanner.nextInt();
        
        for(int i=1;i<=number;i++) {
            if(i%2==1)
                System.out.println(i+"는 홀수입니다.");
        }
        
        //4. 1부터 사용자가 입력한 숫자까지의
        //   곱을 구하는 for문
        System.out.print("숫자 입력: ");
        number = scanner.nextInt();
        
        int mul=1;
        if(number<=14) {
            for(int i=1;i<=number;i++) {
                mul*=i;
            }
            System.out.println("곱은 "+mul+"입니다.");
        }
        else
            System.out.println("오버플로우 발생!");
        
        scanner.close();
    }
}