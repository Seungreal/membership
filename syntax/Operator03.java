package syntax;
//비교연산자
public class Operator03 {

    public static void main(String[] args) {
        int number1 = 3;
        int number2 = 4;
        
        System.out.println("number1 > number2: "+(number1 > number2));
        System.out.println("number1 >= number2: "+(number1 >= number2));
        System.out.println("number1 < number2: "+(number1 < number2));
        System.out.println("number1 <= number2: "+(number1 <= number2));
        System.out.println("number1 == number2: "+(number1 == number2));
        System.out.println("number1 != number2: "+(number1 != number2));

        System.out.println("===참조형 변수의 비교===");
        
        String string1 = new String("abc");
        String string2 = "abc";
        String string3 = string2;
        
        System.out.println("string1: "+string1);
        System.out.println("string2: "+string2);
        System.out.println("string3: "+string3);
        
        System.out.println("===비교연산자를 사용할 경우===");
        System.out.println("string1 == string2: "+(string1==string2));
        System.out.println("string1 == string3: "+(string1==string3));
        System.out.println("string2 == string3: "+(string2==string3));
        System.out.println("-----------------------------");
        
        System.out.println("===equals 메소드를 통한 비교===");
        System.out.println("string1.equals(string2): "+string1.equals(string2));
        System.out.println("string1.equals(string3): "+string1.equals(string3));
        System.out.println("string2.equals(string3): "+string2.equals(string3));
        System.out.println("-----------------------------");
    }

}
