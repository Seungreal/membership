package array;
//가변배열
//다차원 배열중 각 배열의 길이가 제각각 다른 형태인 배열
//int[][] intArray = new int[3][]일 경우
//intArray[0] = new int[3]
//intArray[0] = new int[4]
//intArray[0] = new int[10]

import java.util.Random;

public class Array04 {
    private static final int MAX_SIZE =5;
    public static void main(String[] args) {
        int[][] intArray = new int[3][];
        Random random = new Random();
        
        for(int i=0;i<intArray.length;i++) {
            int size = random.nextInt(MAX_SIZE)+1;
            intArray[i]=new int[size];
        }
        System.out.println("intArray의 각 배열의 크기");
        System.out.println("intArray[0].length: "+intArray[0].length);
        System.out.println("intArray[1].length: "+intArray[1].length);
        System.out.println("intArray[2].length: "+intArray[2].length);
    }
}
