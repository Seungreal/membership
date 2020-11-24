package syntax;
// printf
// 출력할 내용에 %문자를 사용하여
// 우리가 원하는 내용을 특정 형식으로 출력 가능하다

// 공백문자
// \t: 탭
// \n: 개행
public class Printf {
    public static void main(String[] args) {
        //1. 10진법 정수
        int number = 34;
        System.out.println("-----1. 10진법 정수-----");
        //A. 그대로 출력
        System.out.printf("A. %d\n",number);
        //B. 오른쪽 정렬 5자리
        System.out.printf("B. %5d\n",number);
        //C. 왼쪽 정렬 5자리
        System.out.printf("C. %-5d(끝)\n",number);
        //D. 오른쪽 정렬 5자리(0으로 채움)
        System.out.printf("D. %05d\n",number);
        
        //2. 8진법 정수
        System.out.println("-----2. 8진법 정수-----");
        //A. 그대로 출력
        System.out.printf("A. %o\n",number);
        //B. 오른쪽 정렬 5자리
        System.out.printf("B. %5o\n",number);
        //C. 왼쪽 정렬 5자리
        System.out.printf("C. %-5o(끝)\n",number);
        //D. 오른쪽 정렬 5자리(0으로 채움)
        System.out.printf("D. %05o\n",number);
        
        //3. 16진법 정수
        number = 30;
        System.out.println("-----3. 16진법 정수-----");
        //A. 그대로 출력하고, 알파벳 소문자
        System.out.printf("A. %x\n",number);
        //B. 그대로 출력하고, 알파벳 대문자
        System.out.printf("B. %X\n",number);
        //C. 오른쪽 정렬 5자리, 알파벳 소문자
        System.out.printf("C. %5x\n",number);
        //D. 오른쪽 정렬 5자리, 알파벳 대문자
        System.out.printf("D. %5X\n",number);
        //E. 왼쪽 정렬 5자리, 알파벳 소문자
        System.out.printf("E. %-5x(끝)\n",number);
        //F. 왼쪽 정렬 5자리, 알파벳 대문자
        System.out.printf("F. %-5X(끝)\n",number);
        //G. 오른쪽 정렬 5자리, 알파벳 대문자
        System.out.printf("G. %05X\n",number);
        
        //4. 실수
        System.out.println("-----4. 실수-----");
        double myDouble = 1234.5678;
        //A. 그대로 출력
        System.out.printf("A. %f\n",myDouble);
        //B. 오른쪽 정렬 12자리
        System.out.printf("B. %12f\n",myDouble);
        //C. 왼쪽 정렬 12자리
        System.out.printf("C. %-12f(끝)\n",myDouble);
        //D. 소숫점 2번째자리
        System.out.printf("D. %.2f\n",myDouble);
        //E. 오른쪽 정렬 12자리, 소숫점 3자리
        System.out.printf("E. %12.3f\n",myDouble);
        //F. 왼쪽 10자리, 소숫점 1자리
        System.out.printf("F. %-10.1f(끝)\n",myDouble);
        //G. 오른쪽 12자리, 소숫점 2자리,0 채움
        System.out.printf("G. %012.2f\n",myDouble);
        
        //5. 과학표기법(지수로그 e)
        System.out.println("-----5. 과학표기법-----");
        //A. 과학표기법 출력
        System.out.printf("A. %e\n",myDouble);
        
        //6. 문자열
        System.out.println("-----6.문자열-----");
        String string1 = new String("abcDEFghi");
        //A. 그대로 출력
        System.out.printf("A. %s\n",string1);
        //B. 대문자 출력
        System.out.printf("B. %S\n",string1);
        
        //주의점
        // 1. 내용이 더 길면 자릿수 지정은 무시된다
        System.out.printf("%3d\n",1234567);
        // 2. 잘못된 %문자는 에러
        //System.out.printf("%z\n",1234567);
        // 3. 맞지 않는 형식 에러
        //System.out.printf("%d\n",123.45);
        // 4. 매개변수 갯수 에러
        System.out.printf("%d %f %s\n",1, 2.34, "abc",4,5.67);
        //System.out.printf("%d %d %d %d\n",1,2,3);
    }
}
