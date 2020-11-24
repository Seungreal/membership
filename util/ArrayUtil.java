package util;

import array.Student;
import array.Post;

//배열을 사용하는데 도움이 되는 메소드를 모아둔

//ArrayUtil 클래스

public class ArrayUtil {
    // 파라미터로 넘어온 itn[]을 출력하는
    // print(int[]) 메소드
    public static void print(String arrayName, int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("%s[%d]: %d\n", arrayName, i, intArray[i]);
        }
    }

    // 파라미터로 넘어온 int[]을 오름차순 정렬하는
    // sortByASC
    public static void sortByASC(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] > intArray[i + 1]) {
                int temp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = temp;
                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 int[]을 내림차순 정렬하는
    // sortByDSC
    public static void sortByDSC(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            if (intArray[i] < intArray[i + 1]) {
                int temp = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = temp;
                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 int배열에서
    // 같이 넘어온 숫자가 존재하는지
    // 존재하면 true 아니면 false
    // contains()
    public static boolean contains(int[] intArray, int number) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == number) {
                return true;
            }
        }

        return false;
    }

    public static int size(int[] intArray) {
        return intArray.length;
    }

    // 2.int배열에 파라미터로 넘어온 int를
    // 항상 가장 마지막 칸에 추가
    public static int[] add(int[] intArray, int element) {
        int size = size(intArray);
        // 1.intArray의 내용을 임시 배열에 복사
        int[] temp = new int[size];
        for (int i = 0; i < intArray.length; i++)
            temp[i] = intArray[i];
        // 2.intArray를 크기가 1 늘어난 int 배열로 새로 초기화
        intArray = new int[size + 1];
        // 3.임시배열의 내용을 새로 초기화된 intArray에 넣어줌
        for (int i = 0; i < size; i++)
            intArray[i] = temp[i];
        // 4.intArray의 가장 마지막 index에 element를 넣어준다
        intArray[size] = element;

        return intArray;
    }

    // 배열과 index를 넘기면 해당 배열에서 인덱스를 삭제하고
    // 크기가 줄어든 배열을 리턴하는 메소드
    public static int[] removeByIndex(int[] array, int index) {
        int size = size(array);

        // 1.유효하지 않은 인덱스
        if (index < 0 || index > size - 1)
            return array;

        int[] temp = new int[size];
        for (int i = 0; i < size; i++)
            temp[i] = array[i];
        array = new int[size - 1];

        // 2.가장 앞인 인덱스
        if (index == 0) {
            for (int i = 0; i < size - 1; i++)
                array[i] = temp[i + 1];
        }
        // 3.가장 뒤인 인덱스
        else if (index == size - 1) {
            for (int i = 0; i < size - 1; i++)
                array[i] = temp[i];
        }
        // 4.중간에 있는 인덱스
        else {
            for (int i = 0; i < index; i++)
                array[i] = temp[i];
            for (int i = index; i < size - 1; i++)
                array[i] = temp[i + 1];
        }
        return array;
    }

    // 해당 배열에서 특정 요소가
    // 몇번 인덱스에 있는지 확인하는
    // indexOf()메소드
    // 단 존재하지않으면 return -1
    public static int indexOf(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    // 파라미터로 넘어온 element와 동일한
    // element를 삭제하는 remove메소드
    public static int[] remove(int[] array, int element) {
        return removeByIndex(array, indexOf(array, element));
    }

    // add,indexOf,removeByIndex,remove,contains를
    // String기준으로 오버로딩
    public static boolean contains(String[] strArray, String element) {
        for (int i = 0; i < size(strArray); i++) {
            if (strArray[i].equalsIgnoreCase(element)) {
                return true;
            }
        }

        return false;
    }

    public static int size(String[] strArray) {
        return strArray.length;
    }

    public static String[] add(String[] strArray, String element) {
        int size = size(strArray);

        String[] temp = new String[size];
        for (int i = 0; i < strArray.length; i++)
            temp[i] = strArray[i];

        strArray = new String[size + 1];

        for (int i = 0; i < size; i++)
            strArray[i] = temp[i];

        strArray[size] = element;

        return strArray;
    }

    public static String[] removeByIndex(String[] array, int index) {
        int size = size(array);

        // 1.유효하지 않은 인덱스
        if (index < 0 || index > size - 1)
            return array;

        String[] temp = new String[size];
        for (int i = 0; i < size; i++)
            temp[i] = array[i];
        array = new String[size - 1];

        for (int i = 0; i < index; i++)
            array[i] = temp[i];
        for (int i = index; i < size - 1; i++)
            array[i] = temp[i + 1];

        return array;
    }

    public static int indexOf(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }

    public static String[] remove(String[] array, String element) {
        return removeByIndex(array, indexOf(array, element));
    }

    // Student 객체에 대한
    // 1.contains
    // 2.indexOf
    // 3.add
    // 4.removeByIndex
    // 5.remove
    // 단 i번째와 element가 같은지 비교할때는
    // id가 같고 name이 같으면 같은 걸로 판정
    public static boolean contains(Student[] studentArray, Student s) {
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(Student[] studentArray, Student s) {
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i].equals(s))
                return i;
        }
        return -1;
    }

    public static int size(Student[] studentArray) {
        return studentArray.length;
    }

    public static Student[] add(Student[] studentArray, Student s) {
        int size = size(studentArray);

        Student[] temp = new Student[size];
        for (int i = 0; i < size; i++)
            temp[i] = studentArray[i];

        studentArray = new Student[size + 1];

        for (int i = 0; i < size; i++)
            studentArray[i] = temp[i];

        studentArray[size] = s;

        return studentArray;
    }

    public static Student[] removeByIndex(Student[] studentArray, int index) {
        int size = size(studentArray);

        // 1.유효하지 않은 인덱스
        if (index < 0 || index > size - 1)
            return studentArray;

        Student[] temp = new Student[size];
        for (int i = 0; i < size; i++)
            temp[i] = studentArray[i];
        studentArray = new Student[size - 1];

        for (int i = 0; i < index; i++)
            studentArray[i] = temp[i];
        for (int i = index; i < size - 1; i++)
            studentArray[i] = temp[i + 1];

        return studentArray;
    }

    public static Student[] remove(Student[] array, Student s) {
        return removeByIndex(array, indexOf(array, s));
    }

    // Post배열
    public static Post[] add(Post[] pArray, Post p) {
        Post[] temp = new Post[pArray.length];
        for (int i = 0; i < pArray.length; i++)
            temp[i] = pArray[i];

        pArray = new Post[pArray.length + 1];

        for (int i = 0; i < temp.length; i++)
            pArray[i] = temp[i];

        pArray[pArray.length-1] = p;

        return pArray;
    }
    
    public static Post[] removeByIndex(Post[] pArray,int index) {
        Post[] temp = new Post[pArray.length];
        temp = pArray;
        pArray = new Post[pArray.length - 1];
        for (int i = 0; i < index; i++)
            pArray[i] = temp[i];
        for (int i = index; i < temp.length - 1; i++) {
            pArray[i] = temp[i + 1];
        }
        return pArray;
    }
}
