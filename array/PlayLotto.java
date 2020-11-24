package array;
//로또게임

//사용자가 숫자를 선택해서
//컴퓨터가 만들어준 숫자들과 비교하여
//6개 일치:1등
//5개 일치:2등
//4개 일치:3등
//3개 일치:4등
//이 출력되는 프로그램
//단 사용자가 숫자를 선택할 때에는
//불가능한 번호나 중복된 번호는 입력할수없게

import java.util.Random;
import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

public class PlayLotto {
    private static final int SIZE = 6;
    private static final int MAX = 45;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int[] userNumbers = new int[SIZE];
        int[] computerNumbers = new int[SIZE];
        int score = 0;

        for (int i = 0; i < computerNumbers.length; i++) {
            int randomNumber = random.nextInt(MAX) + 1;
            while (ArrayUtil.contains(computerNumbers, randomNumber)) {
                randomNumber = random.nextInt(MAX) + 1;
            }
            computerNumbers[i] = randomNumber;
        }
        ArrayUtil.sortByASC(computerNumbers);

        for (int i = 0; i < userNumbers.length; i++) {
            int userNumber = ScannerUtil.nextInt(scan, (i + 1) + "번째 숫자를 입력:", 1, MAX);
            while (ArrayUtil.contains(userNumbers, userNumber)) {
                userNumber = ScannerUtil.nextInt(scan, "중복입력하셨습니다. " + (i + 1) + "번째 숫자를 입력:", 1, MAX);
            }
            userNumbers[i] = userNumber;
        }
        ArrayUtil.sortByASC(userNumbers);

        System.out.print("사용자가 선택한 번호는 ");
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.print(userNumbers[i] + "번 ");
        }
        System.out.println("입니다.");

        System.out.print("당첨 번호는 ");
        for (int i = 0; i < computerNumbers.length; i++) {
            System.out.print(computerNumbers[i] + "번 ");
        }
        System.out.println("입니다.");

        // ArrayUtil.contains를 사용하여
        // true가 나올때마다 점수를 1점씩 올린다
        for (int i = 0; i < userNumbers.length; i++) {
            if (ArrayUtil.contains(computerNumbers, userNumbers[i]))
                score++;
        }

        switch (score) {
        case 6:
            System.out.printf("총 %d개 맞추셨습니다. 1등입니다.\n",score);
            break;
        case 5:
            System.out.printf("총 %d개 맞추셨습니다. 2등입니다.\n",score);
            break;
        case 4:
            System.out.printf("총 %d개 맞추셨습니다. 3등입니다.\n",score);
            break;
        case 3:
            System.out.printf("총 %d개 맞추셨습니다. 4등입니다.\n",score);
            break;
        default:
            System.out.printf("총 %d개 맞추셨습니다. 꽝입니다.\n",score);
        }

        scan.close();
    }
}
