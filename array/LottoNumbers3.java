package array;
//동적할당을 이용한 로또번호 추첨기

import java.util.Random;

import util.ArrayUtil;

public class LottoNumbers3 {
    private static final int SIZE=6;
    private static final int MAX=45;
    public static void main(String[] args) {
        Random random = new Random();
        int[] lottoNumbers = new int[0];
        while(lottoNumbers.length<SIZE) {
            int radomNumber = random.nextInt(MAX)+1;
            if(!ArrayUtil.contains(lottoNumbers, radomNumber))
                lottoNumbers=ArrayUtil.add(lottoNumbers, radomNumber);
        }
        for(int i=0;i<lottoNumbers.length;i++) {
            System.out.printf("%d번 숫자: %d\n",i,lottoNumbers[i]);
        }
    }
}
