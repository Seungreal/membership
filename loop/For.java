package loop;
//반복문
//특정조건이 트루가 나오는동안
//코드블럭을 반복시키는 코드

//for반복문:제어변수가 조건식을 만족하는 동안
//코드를 반복하고 제어변수의 값을 변화시켜서
//트루면 반복 폴스면 종료가 된다.

public class For {
    public static void main(String[] args) {
        //for(제어변수의 선언과 초기회;조건식;변화식){
        //  반복할 코드}
        
        for(int i=0;i<4;i++)
            System.out.println("i의 현재값: "+i);
        for(int i=10;i<0;i++)
            System.out.println("?");
        for(int i=0;i<4;i++);{
            System.out.println("?");
        }
        for(int i=0;i<4;i++){
            System.out.println(i);
        }
        //System.out.println(i);
        int i=0;
        for(;i<4;i++){
            System.out.println(i);
        }
    }
}