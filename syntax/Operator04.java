package syntax;
// 논리연산자
// 논리연산자는 2개의 boolean값 혹은 1개의 boolean값에 대한 연산을 한다
// && ㅣㅣ !
public class Operator04 {
    public static void main(String[] args) {
        System.out.println("&&");
        System.out.println("true && true: "+(true && true));
        System.out.println("true && false: "+(true && false));
        System.out.println("false && true: "+(false /*&& true*/));
        System.out.println("false && false: "+(false /*&& false*/));
        System.out.println("-----------------------------");
        
        System.out.println("-----||-----");
        System.out.println("true || true: "+(true /*|| true*/));
        System.out.println("true || false: "+(true /*|| false*/));
        System.out.println("false || true: "+(false || true));
        System.out.println("false || false: "+(false || false));
        System.out.println("-----------------------------");
        
        System.out.println("-----!-----");
        System.out.println("!true: "+!true);
        System.out.println("!false: "+!false);
        
        int number = 5;
        System.out.println("number > 0 && number < 10: "+(number > 0 && number < 10));
        number = -1;
        System.out.println("number < 0 || number > 100: "+(number < 0 || number > 100));
        String password = "1q2w3e";
        String userPassword = "12345";
        System.out.println("password.equals(userPassword): "+password.equals(userPassword));
        System.out.println("!password.equals(userPassword): "+!password.equals(userPassword));
        
    }

}
