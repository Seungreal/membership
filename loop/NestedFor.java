package loop;
//중첩 for반복문

public class NestedFor {
    public static void main(String[] args) {
        for(int i=1;i<=3;i++) {
            int value=0;
            for(int j=11;j<=14;j++) {
                System.out.printf("i의 현재값: %d, j의 현재값: %d\n",i,j);
            }
            System.out.println("value의 현재값: "+value);
        }
    }

}
