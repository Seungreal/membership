package array;
//2차원 배열

public class Array2D {
    public static void main(String[] args) {
        //2차원 배열은
        //데이터타입[][] 배열이름 = new 데이터타입[배열의 개수][배열 안의 칸수]
        //로 선언한다.
        int[][] array = new int[3][4];
        
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[i].length;j++) {
                System.out.printf("array[%d][%d]: %d\n",i,j,array[i][j]);
            }
        }
    }
}
