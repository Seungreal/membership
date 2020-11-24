package array;
//배열의 동적할당

import util.ArrayUtil;

public class DydamicAlloc {
    public static void main(String[] args) {
        int[] array = new int[0];
        System.out.println("array.length:" + array.length);
        array = ArrayUtil.add(array, 1);
        System.out.println("array.length:" + array.length);
        array = ArrayUtil.add(array, 2);
        System.out.println("array.length:" + array.length);
        array = ArrayUtil.add(array, 3);
        System.out.println("array.length:" + array.length);
        array = ArrayUtil.add(array, 4);
        System.out.println("array.length:" + array.length);

        for (int i = 0; i < array.length; i++)
            System.out.printf("array[%d]:%d\n", i, array[i]);

        // 잘못된 인덱스 삭제
        array = ArrayUtil.removeByIndex(array, -1);
        System.out.println("잘못된 인덱스 array.length:" + array.length);

        // 가장 앞
        System.out.println("0번 인덱스 삭제전 array[0]:" + array[0]);
        array = ArrayUtil.removeByIndex(array, 0);
        System.out.println("0번 인덱스 삭제후 array[0]:" + array[0]);

        // 가장 마지막
        System.out.println("2번 인덱스 삭제전 array.length:" + array[2]);
        array = ArrayUtil.removeByIndex(array, 2);
        System.out.println("2번 인덱스 삭제전 array.length:" + array[1]);

        // 중간
        array = ArrayUtil.add(array, 3);
        array = ArrayUtil.add(array, 30);
        array = ArrayUtil.add(array, 300);
        array = ArrayUtil.add(array, 3000);
        System.out.println("삭제전");
        for (int i = 0; i < array.length; i++)
            System.out.printf("array[%d]:%d\n", i, array[i]);
        array = ArrayUtil.removeByIndex(array, 3);
        System.out.println("삭제후");
        for (int i = 0; i < array.length; i++)
            System.out.printf("array[%d]:%d\n", i, array[i]);

        System.out.println("remove(배열,element)");
        System.out.println("ArrayUtil.indexOf(array,300): " + ArrayUtil.indexOf(array, 300));
        array = ArrayUtil.remove(array, 300);
        System.out.println("ArrayUtil.indexOf(array,300): " + ArrayUtil.indexOf(array, 300));
        System.out.println("ArrayUtil.indexOf(array,555): " + ArrayUtil.indexOf(array, 555));
        array = ArrayUtil.remove(array, 555);
        System.out.println("ArrayUtil.indexOf(array,300): " + ArrayUtil.indexOf(array, 555));

        String[] strArray = new String[0];
        strArray = ArrayUtil.add(strArray, "aaa");
        strArray = ArrayUtil.add(strArray, "bbb");
        strArray = ArrayUtil.add(strArray, "ccc");
        strArray = ArrayUtil.add(strArray, "ddd");
        strArray = ArrayUtil.add(strArray, "eee");
        for (int i = 0; i < ArrayUtil.size(strArray); i++)
            System.out.printf("strArray[%d]: %s\n", i, strArray[i]);
               
        strArray = ArrayUtil.remove(strArray, "ccc");        
        for (int i = 0; i < ArrayUtil.size(strArray); i++)
            System.out.printf("strArray[%d]: %s\n", i, strArray[i]);
        
        Student[] s = new Student[0];
        Student element = new Student();
        element.setId(1);
        element.setName("aaa");
        element.setKorean(70);
        element.setEnglish(70);
        element.setMath(69);
        s=ArrayUtil.add(s, element);
        System.out.println(s[0].getId());
        System.out.println(s[0].getName());
        System.out.println(s[0].getKorean());
        System.out.println(s[0].getEnglish());
        System.out.println(s[0].getMath());
        
        s=ArrayUtil.removeByIndex(s, 0);
        System.out.println(s.length);
    }
}
