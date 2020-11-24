package branch;
//조건식이 여러개
//if-else if-...-else
public class IfElseIf01 {

    public static void main(String[] args) {
        int age =8;
        if(age<=5) {
            System.out.println("유아입니다.");
        }
        else if(age<=13) {
            System.out.println("어린이입니다.");
        }
        else if(age<=17) {
            System.out.println("청소년입니다.");
        }
        else {
            System.out.println("성인입니다.");
        }

    }

}
