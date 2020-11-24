package loop;
//while 반복문

public class While01 {
    public static void main(String[] args) {
        for(int i=0;i<3;i++) {
            System.out.println("i의 현재값: "+i);
        }
        
        int i=0;
        
        while(i<3) {
            System.out.println("i의 현재값: "+i);
            i++;
        }
    }

}
