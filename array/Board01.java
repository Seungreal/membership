package array;
//게시판 관리 프로그램

//게시판에는
//글번호,제목,내용,작성자 4가지 정보가 필요
//글쓰기,목록보기,개별보기,수정하기,삭제하기 기능

import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

public class Board01 {
    private static final int BOARD_MAX = 10;

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Post[] pArray = new Post[0];
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("게시판 관리프로그램");
            System.out.println("1.글쓰기 2. 목록보기 3. 종료");
            int userChoice = ScannerUtil.nextInt(scan, ">", 1, 3);
            if (userChoice == 1) {
                pArray = writePost(scan, pArray);
            } else if (userChoice == 2) {
                pArray = showBoard(scan, pArray);
            } else {
                System.out.println("종료합니다.");
                break;
            }
        }

        scan.close();
    }

    private static Post[] writePost(Scanner scan, Post[] pArray) {
        Post p = new Post();

        p.setNumber(pArray.length + 1);
        System.out.print("제목을 입력하세요.\n>");
        p.setSubject(ScannerUtil.nextLine(scan));
        System.out.print("내용을 입력하세요.\n>");
        p.setContents(ScannerUtil.nextLine(scan));
        System.out.print("작성자를 입력하세요.\n>");
        p.setWriter(ScannerUtil.nextLine(scan));

        pArray = ArrayUtil.add(pArray, p);

        return pArray;
    }

    private static Post[] showBoard(Scanner scan, Post[] pArray) {
        if (pArray.length == 0)
            System.out.println("현재 아무 게시글이 없습니다.");
        else {
            System.out.println("----------------");
            System.out.println("번호 제목     작성자");
            for (int i = pArray.length - 1; i >= 0; i--) {
                System.out.printf("%d  %s     %s\n", pArray[i].getNumber(), 
                        pArray[i].getSubject(), pArray[i].getWriter());
            }
            System.out.println("----------------");
            System.out.print("내용을 확인할 게시물의 번호를 입력하세요(0은 돌아가기)\n");
            int userChoice = ScannerUtil.nextInt(scan, ">", 0, BOARD_MAX);
            if (userChoice != 0) {
                pArray = showPost(scan, pArray, userChoice - 1);
            }
        }
        return pArray;
    }

    private static Post[] showPost(Scanner scan, Post[] pArray, int index) {
        Post p = pArray[index];

        System.out.printf("제목 : %s\n", p.getSubject());
        System.out.printf("내용 : %s\n", p.getContents());

        System.out.print("수정하시려면 1,삭제하시려면 2,돌아가시려면 0\n");
        int userChoice = ScannerUtil.nextInt(scan, ">", 0, 2);
        if (userChoice == 1) {
            updatePost(scan, p);
            pArray = showPost(scan, pArray, index);
        } else if (userChoice == 2) {
            pArray = deletePost(scan, pArray, index);
            showBoard(scan, pArray);
        }
        pArray = showBoard(scan, pArray);
        return pArray;

    }

    private static void updatePost(Scanner scan, Post p) {
        System.out.println("수정할 내용을 입력하세요.");
        p.setContents(ScannerUtil.nextLine(scan));
    }

    private static Post[] deletePost(Scanner scan, Post[] pArray, int index) {
        System.out.print("해당 게시글을 정말 삭제하시겠습니까? y/n: ");
        String agree = ScannerUtil.nextLine(scan);
        if (agree.equals("y")) {
            pArray = ArrayUtil.removeByIndex(pArray, index);
        }

        return pArray;
    }
}
