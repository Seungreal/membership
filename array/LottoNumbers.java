package array;
//로또번호 생성기

import java.util.Random;

import util.ArrayUtil;

public class LottoNumbers {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {
        Random random = new Random();

        int[] lottoNumbers = new int[SIZE];

        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(MAX) + 1;
        }

        ArrayUtil.print("lottoNumbers", lottoNumbers);
        System.out.println("1. 먼저 채워놓고 중복인 곳 다시 넣기");
        // 중복이란 인덱스가 다르지만 인덱스들의 값이 같을 때
        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < lottoNumbers.length; j++) {
                if (i != j && lottoNumbers[i] == lottoNumbers[j]) {
                    System.out.print(lottoNumbers[i]+"를 ");
                    lottoNumbers[i] = random.nextInt(MAX) + 1;
                    System.out.println(lottoNumbers[i]+"로 바꿈");
                    j = -1;
                }
            }
        }
        ArrayUtil.sortByASC(lottoNumbers);
        ArrayUtil.print("lottoNumbers", lottoNumbers);
    }
}
