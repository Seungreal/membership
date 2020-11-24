package array;

import util.ArrayUtil;

public class ArrayUtilTest {
    public static void main(String[] args) {
        // 배열을 초기화할때 2가지방법이 있는데
        // 첫번째는 int[] arr = new int[크기];
        // 그리고 각 인덱스마다 값을 넣어주는 방법

        // 2번째는 즉석에서 배열을 만들어서
        // 그 배열로 초기화 하는 방법
        int[] arr = { 5, 1, 2, 3, 0 };

        ArrayUtil.print("intArray", arr);
        System.out.println();

        ArrayUtil.sortByASC(arr);
        System.out.println("오름차순 정렬 후");
        ArrayUtil.print("intArray", arr);
        System.out.println();
        
        ArrayUtil.sortByDSC(arr);
        System.out.println("내림차순 정렬 후");
        ArrayUtil.print("intArray", arr);
        System.out.println();
    }
}
