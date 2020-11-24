package syntax;
// 할당연산자
// 뒤에 나오는 값을 연산하여
// 앞의 변수 혹은 상수에 할당한다

public class Operator02 {
    public static void main(String[] args) {
        int number;
        
        number = 5;
        System.out.println("number의 현재값: "+number);
        
        number += 3;
        System.out.println("number의 현재값: "+number);
        
        number -= 2;
        System.out.println("number의 현재값: "+number);
        
        number *= 3;
        System.out.println("number의 현재값: "+number);
        
        number /= 4;
        System.out.println("number의 현재값: "+number);
        
        number %= 5;
        System.out.println("number의 현재값: "+number);
    }

}
