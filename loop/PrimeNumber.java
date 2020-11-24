package loop;
//1부터 100까지 소수를 구하는 프로그램
public class PrimeNumber {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++) {
            int count=0;
            for(int j=1;j<=i;j++) {
                if(i%j==0) {
                    count++;
                }
            }
            if(count==2) {
                System.out.println(i+"");
            }
        }
   }
}