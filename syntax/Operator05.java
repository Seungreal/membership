package syntax;
// 비트연산자
// 비트연산자는 정수를 비트로 변환해서
// 해당 자리에 대한 연산을 한다.

// & | ^ ~ << >> >>>
// &: 2개의 정수를 이진법으로 변환하고 같은 자리가 1일때만 1이 나오게 된다
// |: 2개의 정수를 이진법으로 변환하고 같은 자리가 한개라도
public class Operator05 {

    public static void main(String[] args) {
        byte myByte1 = 25;
        // 0001 1001
        byte myByte2 = 14;
        // 0000 1110
        
        //1. & 연산
        //0001 1001
        //0000 1110
        //0000 1000
        System.out.println("myBytee1 & myByte2: "+(myByte1 & myByte2));
        
        //2. | 연산
        //0001 1001
        //0000 1110
        //0001 1111
        System.out.println("myBytee1 | myByte2: "+(myByte1 | myByte2));
        
        //3. ^ 연산
        //0001 1001
        //0000 1110
        //0001 0111
        System.out.println("myBytee1 ^ myByte2: "+(myByte1 ^ myByte2));
        
        //4. ~ 연산
        //0001 1001
        //1110 0110
        System.out.println("~mybyte1: "+ ~myByte1);
        
        //5. << 연산
        //0001 1001 << 3
        //1100 1000
        System.out.println("mybyte1 << 3: "+ (byte)(myByte1 << 3));

        //6. >> 연산
        //0001 1001 >> 4
        //0000 0001
        System.out.println("myByte1 >> 4: "+ (byte)(myByte1 >> 4));
        myByte1 = -120;
        //1000 1000 >> 3
        //1111 0001
        System.out.println("myByte1 >> 3: "+ (byte)(myByte1 >> 3));
        
        //7. >>> 연산
        //1000 1000 >>> 3
        //1111 0001
        System.out.println("myByte1 >>> 3: "+ (byte)(myByte1 >>> 3));
    }

}
