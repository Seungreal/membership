package board.viewers;

import java.util.Scanner;

import array.Post;
import util.ArrayUtil;
import util.ScannerUtil;

public class BoardViewer02 {
    private Scanner scan;
    private Post[] pArray;
    private int id =1;

    public BoardViewer02() {
        scan = new Scanner(System.in);
        pArray = new Post[0];
    }

    public void showMenu() {
        while (true) {
            System.out.println("게시판 관리 프로그램");
            String message = "1.새 글쓰기 2.목록 보기 3.종료\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
            if (userChoice == 1) {
                addBoard();
            } else if (userChoice == 2) {
                selectAll();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 게시글을 입력하고 해당 글을
    // 배열에 추가해주는 addBoard메소드
    // 어떤 메소드를 사용할때
    // 해당 클래스의 객체를 만들어서 사용하기 때문에
    // static키워드는 붙이지않는다
    private void addBoard() {
        Post p = new Post();

        System.out.print("제목: ");
        p.setSubject(ScannerUtil.nextLine(scan));
        p.setNumber(id++);
        System.out.print("작성자: ");
        p.setWriter(ScannerUtil.nextLine(scan));
        System.out.print("내용: ");
        p.setContents(ScannerUtil.nextLine(scan));

        pArray = ArrayUtil.add(pArray, p);
    }

    // 글의 목록을 출력하는 selectAll메소드
    private void selectAll() {
        if (pArray.length == 0) {
            System.out.println("작성된 게시글이 없습니다.");
        } else {
            for (int i = pArray.length-1; i >= 0; i--)
                System.out.printf("%d %s\n", i+1, pArray[i].getSubject());

            String message = "상세보기할 글 번호를 선택해주세요(0은 뒤로가기)\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 0, pArray.length) - 1;

            if (userChoice != -1) {
                selectOne(userChoice);
            }
        }
    }
    
    private void selectOne(int index) {
        Post p = pArray[index];
        
        System.out.println("제목: "+p.getSubject());
        System.out.println("글번호: "+p.getNumber());
        System.out.println("작성자: "+p.getWriter());
        System.out.println("------------");
        System.out.println(p.getContents());
        
        String message = "1.수정 2.삭제 3.뒤로가기\n>";
        int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
        if(userChoice==1) {
            updateBoard(index);
            selectOne(index);
        }else if(userChoice==2) {
            deleteBoard(index);
            selectAll();
        }else if(userChoice==3) {
            selectAll();
        }
    }
    
    private void updateBoard(int index) {
        System.out.println("제목: ");
        pArray[index].setSubject(ScannerUtil.nextLine(scan));
        System.out.println("내용: ");
        pArray[index].setContents(ScannerUtil.nextLine(scan));
    }
    
    private void deleteBoard(int index) {
        System.out.println("정말로 삭제하시겠습니까?y/n");
        String agree = ScannerUtil.nextLine(scan);
        if(agree.equals("y"))
            pArray = ArrayUtil.removeByIndex(pArray,index);
    }
}
