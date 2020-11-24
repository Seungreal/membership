package array;

import java.util.Random;

import util.ArrayUtil;

public class LottoNumbers2 {
    private static final int SIZE = 6;
    private static final int MAX = 45;
    public static void main(String[] args) {
        Random random = new Random();
        int[] lottoNumbers = new int[SIZE];
        
        for(int i=0; i<lottoNumbers.length;i++) {
            int randomNumber = random.nextInt(MAX)+1;
            while(ArrayUtil.contains(lottoNumbers, randomNumber)) {
                randomNumber = random.nextInt(MAX)+1;
            }
            lottoNumbers[i]=randomNumber;
        }
        
        System.out.println("-----중복제거 ver.2");
        ArrayUtil.sortByASC(lottoNumbers);
        ArrayUtil.print("lottoNumbers", lottoNumbers);
    }
}
