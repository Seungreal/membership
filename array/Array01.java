package array;
//배열
//똑같은 데이터타입을 지정한 크기만큼 모아두어서
//한번에 여러개를 다룰 수 있게 하는 방법
//각각을 배열0번,배열1번... 지정하면
//각각의 공간을 호출할 수 있다.
public class Array01 {
    public static void main(String[] args) {
        //배열 선언하기
        //데이터타입[] 배열이름 = new 데이터타입[크기]
        
        //int5개가 모여있는 int배열 intArray를 선언
        int[] intArray = new int[5];
        
        //index
        //index란 배열같이 특정 데이터타입이 모아둔 변수를 다룰때
        //각 공간의 번호를 뜻한다
        //index는 항상 0부터 크기-1까지의 값을 가진다
        //잘못된 인덱스를 넘겨주면 에러
        
        //for문을 이용해서 배열의 내용을 출력
        for(int i=0; i<intArray.length;i++) {
            //배열이름.length는 해당 배열의 크기 리턴
            //배열의 각 공간에 접근할 때에는
            //배열이름[인덱스]로 접근가능
            //배열을 선언할때 크기나
            //각 공간을 접근할때 적는 인덱스는
            //변수가 들어갈 수도 있다.
            System.out.printf("intArray[%d]: %d\n",i,intArray[i]);
        }
        
        //에러 발생
        //System.out.println("intArray[-1]: "+intArray[-1]);
        //System.out.println("intArray[100]: "+intArray[100]);
        
        //배열의 경우 기본형 데이터타입의 배열일땐
        //모든 칸이 0으로 초기화된다.
        //참조형 데이터타입의 배열일땐
        //모든칸이 NULL로 초기화된다.
        
        //배열이름[인덱스]는 하나의 변수처럼 볼수있기때문에
        //해당공간에 값을 입력하거나 저장된 값을 불러올수있다.
        intArray[0] = 15;
        System.out.println("intArray[0]: "+intArray[0]);
    }
}
