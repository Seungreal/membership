package loop;
//무한 루프
//조건식에서 항상 참이 나와서
//해당 루프가 종료되지않고
//프로그램을 강제종료할 때까지
//계속 실행되는 반복문
public class InfiniteLoop {
    public static void main(String[] args) {
        System.out.println("for반복문을 이용한 무한루프");
        //A.컨트롤변수의 값이 변화가 없으면
        System.out.println("for(int i=0;i<1;)");
        //for(int i=0;i<1;) {
        //    System.out.println("for 무한루프 1번");
        //}
        
        //B.반복 조건식이 항상 참이 나오는 형태
        System.out.println("for(int i=0;0<1;i++)");
        //for(int i=0;0<1;i++) {
        //   System.out.println("for 무한루프 2번, i의 현재값: "+i);
        //}
        
        //C.빈 형태의 for문
        System.out.println("for(;;)");
//        for(;;) {
//            System.out.println("for 무한루프 3번");
//        }
        
        //while을 이용한 무한루프
        System.out.println("while반복문을 이용한 무한루프");
        
        System.out.println("A.변화가 없는 변수를 조건식");
        System.out.println("int number=0; while(number<5)");
//        int number=0;
//        while(number<5) {
//            System.out.println("while 무한루프 1번");
//        }
        
        System.out.println("B.항상 참이 나오는 조건식");
        System.out.println("while(0<1)");
//        while(0<1){
//            System.out.println("while 무한루프 2번");
//        }
        
        System.out.println("C.true");
        System.out.println("true");
//        while(true) {
//            System.out.println("while 무한루프 3번");
//        }
    }
}
