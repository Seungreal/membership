package array;

import java.util.Random;

//정렬
//배열에서 정렬하는 코드

public class Sort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArray = new int[5];
        for(int i=0; i<5; i++) {
            intArray[i]=random.nextInt()%100;
        }

        //정렬 전
        System.out.println("--------정렬전---------");
        for(int i=0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n",i,intArray[i]);
        }
        System.out.println("---------------------");
        
        //오름차순 정렬
        System.out.println("------오름차순 정렬-------");
        for(int i=0; i < intArray.length-1; i++) {
            if(intArray[i] > intArray[i+1]) {
                int temp=intArray[i];
                intArray[i]=intArray[i+1];
                intArray[i+1]=temp;
                i=-1;
            }
        }
        for(int i=0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n",i,intArray[i]);
        }
        System.out.println("---------------------");
        
        //내림차순 정렬
        System.out.println("------내림차순 정렬-------");
        for(int i=0; i < intArray.length-1; i++) {
            if(intArray[i] < intArray[i+1]) {
                int temp=intArray[i];
                intArray[i]=intArray[i+1];
                intArray[i+1]=temp;
                i=-1;
            }
        }
        for(int i=0; i < intArray.length; i++) {
            System.out.printf("intArray[%d]: %d\n",i,intArray[i]);
        }
        System.out.println("---------------------");
        
    }
}
