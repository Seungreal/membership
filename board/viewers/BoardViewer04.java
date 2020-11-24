package board.viewers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import array.Post;
import util.ScannerUtil;

public class BoardViewer04 {
    private Scanner scan;
    private ArrayList<Post> list;
    private int id;

    public BoardViewer04() {
        scan = new Scanner(System.in);
        list = new ArrayList<>();
        id = 1;
    }

    public void showMenu() {
        while (true) {
            System.out.println("게시판 관리 프로그램");
            String message = ("1.새글 작성 2.글 목록 보기 3.종료\n>");
            int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
            if (userChoice == 1) {
                addBoard();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("이용해 주셔서 감사합니다.");
                break;
            }
        }
    }

    private void addBoard() {
        Post p = new Post();

        p.setNumber(id++);
        System.out.print("제목: ");
        p.setSubject(ScannerUtil.nextLine(scan));
        System.out.print("작성자: ");
        p.setWriter(ScannerUtil.nextLine(scan));
        System.out.print("내용: ");
        p.setContents(ScannerUtil.nextLine(scan));
        p.setWrittenDate(Calendar.getInstance());
        p.setUpdatedDate(Calendar.getInstance());

        list.add(p);
    }

    private void printAll() {
        if (list.isEmpty()) {
            System.out.println("아직 작성된 글이 없습니다.");
        } else {
            // 향상된 for문,forEach구조
            // for(데이터타입 변수이름 : 리스트)

            // Collection 클래스
            // List,Map,Set에 해당하는 모든 종류의 클래스의
            // 정렬,복사 등의 static메소드가 구현되어있는 클래스

            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.printf("%d. %s\n", i + 1, list.get(i).getSubject());
            }
            
            String message = "상세보기할 글을 선택해주세요(0은 뒤로가기)\n>";
            int userChoice = ScannerUtil.nextInt(scan, message, 0, list.size())-1;
            
            if(userChoice!=-1) {
                printOne(userChoice);
            }
        }
    }
    
    private void printOne(int index) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Post p = list.get(index);
        System.out.println("--------------------------");
        System.out.println("제목: "+p.getSubject());
        System.out.println("작성자: "+p.getWriter());
        System.out.println("작성날짜: "+sdf.format(p.getWrittenDate().getTime()));
        System.out.println("수정날짜: "+sdf.format(p.getUpdatedDate().getTime()));
        System.out.println("--------------------------");
        System.out.println(p.getContents());
        System.out.println("--------------------------");
        
        String message = "1. 수정 2. 삭제 3. 목록으로\n>";
        int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
        if(userChoice==1) {
            updateBoard(index);
            printOne(index);
        }else if(userChoice==2) {
            deleteBoard(index);
            printAll();
        }else if(userChoice==3) {
            printAll();
        }
    }
    
    private void updateBoard(int index) {
        System.out.println("제목: ");
        list.get(index).setSubject(ScannerUtil.nextLine(scan));
        System.out.println("내용: ");
        list.get(index).setContents(ScannerUtil.nextLine(scan));
        list.get(index).setUpdatedDate(Calendar.getInstance());
    }
    
    private void deleteBoard(int index) {
        System.out.print("정말로 삭제하시겠습니까? y/n");
        String agree = ScannerUtil.nextLine(scan);
        if(agree.toLowerCase().equals("y"))
            list.remove(index);
    }
}
