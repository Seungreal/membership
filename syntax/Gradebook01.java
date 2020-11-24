package syntax;
//사용자로부터
//번호 이름
//국어 영어 수학
//를 차례대로 입력받아서
//번호:##번 이름:###
//국어:080점 영어:079점 수학:080점
//총점:239점 평균:79.67점

import java.util.Scanner;
public class Gradebook01 {
    static final int SUBJECT_SIZE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("번호를 입력하세요:");
        int number=scanner.nextInt();
        System.out.printf("이름를 입력하세요:");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.printf("국어점수를 입력하세요:");
        int koran=scanner.nextInt();
        System.out.printf("영어점수를 입력하세요:");
        int english=scanner.nextInt();
        System.out.printf("수학점수를 입력하세요:");
        int math=scanner.nextInt();
        
        int total=koran+english+math;
        //float avr=(float)total/3;
        float avr=(float)total/SUBJECT_SIZE;
        
        System.out.printf("번호:%d번 이름:%s\n",number,name);
        System.out.printf("국어:%03d점 영어:%03d점 수학:%03d점\n",koran,english,math);
        System.out.printf("총점:%3d점 평균:%.2f점",total,avr);
        
        
        scanner.close();
    }

}
