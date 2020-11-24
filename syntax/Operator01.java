package syntax;
// 연산자
// 연산자란 수학적 기호에 프로그래밍적 기능이 정의되어있어서
// 우리가 특정 기호를 쓰면 내부적으로 해당 기능이 실행되는것을 뜻한다
// 연산자에는
// 산술,할당,비교,논리,비트 5가지 연산자가 존재한다
public class Operator01 {
    public static void main(String[] args) {
        // 산술 연산자란, 간단한 사칙연산 + 나머지를 구해주는 연산자이다.
        
        int myNumber1 = 10;
        int myNumber2 = 15;
        
        System.out.println("myNumber1 + myNumber2= "+ (myNumber1+myNumber2));
        System.out.println("myNumber1 - myNumber2= "+ (myNumber1-myNumber2));
        System.out.println("myNumber1 * myNumber2= "+ (myNumber1*myNumber2));
        System.out.println("myNumber1 / myNumber2= "+ (myNumber1/myNumber2));
        //나눗셈의 경우, 정수형과 정수형의 나눗셈은
        //반드시 결과값이 정수형이 나오게 된다.
        System.out.println("myNumber1 % myNumber2= "+ (myNumber1%myNumber2));
        //하지만 산술연산의 경우 한쪽이 실수이면
        //결과값도 실수가 된다.
        System.out.println("myNumber1 + myNumber2= "+ ((double)myNumber1+myNumber2));
        System.out.println("myNumber1 - myNumber2= "+ ((double)myNumber1-myNumber2));
        System.out.println("myNumber1 * myNumber2= "+ ((double)myNumber1*myNumber2));
        System.out.println("myNumber1 / myNumber2= "+ ((double)myNumber1/myNumber2));
        System.out.println("myNumber1 % myNumber2= "+ ((double)myNumber1%myNumber2));
        
        double result = myNumber1 / myNumber2;
        System.out.println("result의 현재값: "+result);
        //위 코드는 0.0이 결과값으로 나오는데
        //myNumber1/myNumber2=
        //int/int기 때문에
        //몫만 온전하게 나온다
        
        //String
        //여러개의 문자를 모아둔 문자열을 관리하는 클래스
        String string = new String();
        string = "abc";
        String string2 = new String();
        string2 = "DEF";
        System.out.println(string+string2);
        System.out.println("123"+456);
        
        //증감연산자
        System.out.println("myNumber1의 현재값: "+myNumber1);
        System.out.println("++myNumber1: "+ ++myNumber1);
        System.out.println("myNumber1의 현재값: "+myNumber1);
        System.out.println("++myNumber1: "+ myNumber1++);
        System.out.println("myNumber1의 현재값: "+myNumber1);
    }

}
