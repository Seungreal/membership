package main;

import java.util.Scanner;
import membership.UserController;
import membership.UserDTO;
public class UserMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserController control = new UserController();
        UserDTO user = new UserDTO();
        while(true) {
            System.out.printf("1.회원가입 2.로그인 3.비밀번호 수정 4.회원탈퇴 "
                    + "5.아이디 중복체크 6.마이페이지\n7.회원목록 8.아이디검색 "
                    + "9.이름검색 10.전체 회원수\n>");
            switch (scan.next()) {
            case "1":
                user = new UserDTO();
                System.out.print("[회원가입] 아이디,비번,이름\n>");
                user.setId(scan.next());
                user.setPassword(scan.next());
                user.setName(scan.next());
                control.PostJoin(user);
                break;
            case "2":
                System.out.print("[로그인] 아이디,비번\n>");
                user.setId(scan.next());
                user.setPassword(scan.next());
                UserDTO login = control.postLogin(user);
                if(login == null) {
                    System.out.println("로그인 실패");
                }else {
                System.out.println(login.getName()+"님 환영합니다.");
                }
                break;
            case "3":
                System.out.print("[비밀번호 수정] 아이디,비번\n>");
                user.setId(scan.next());
                user.setPassword(scan.next());
                control.putPassword(user);
                break;
            case "4":
                System.out.print("[회원탈퇴] 아이디,비번\n>");
                user.setId(scan.next());
                user.setPassword(scan.next());
                control.deleteUser(user);
                break;
            case "5":
                System.out.print("[아이디 중복체크] 아이디\n>");
                boolean check = control.getCheckId(scan.next());
                if(check) {
                    System.out.println("사용가능");
                }else{
                    System.out.println("사용불가");
                }
                break;
            case "6":
                System.out.print("[마이페이지] 아이디,비번\n>");
                user.setId(scan.next());
                user.setPassword(scan.next());
                UserDTO myPage = control.getMyPage(user);
                if(myPage==null) {
                    System.out.println("정보가 없습니다.");
                }else {
                    System.out.printf("아이디: %s\n이름: %s\n",myPage.getId(),myPage.getName());
                }
                break;
            case "7":
                UserDTO[] memberList = control.getMemberList();
                int count = control.getTotalMember();
                for(int i=0;i<count;i++) {
                    System.out.printf("아이디: %s\t이름: %s\n",memberList[i].getId(),memberList[i].getName());
                }
                break;
            case "8":
                System.out.print("[아이디검색] 아이디\n>");
                UserDTO idSearch = control.getIdSearch(scan.next());
                if(idSearch==null) {
                    System.out.println("일치하는 아이디가 없습니다.");
                }else {
                    System.out.printf("아이디: %s\t이름: %s\n",idSearch.getId(),idSearch.getName());
                }
                break;
            case "9":
                System.out.print("[이름검색] 이름\n>");
                UserDTO[] nameSearch = control.getNameSearch(scan.next());
                for(int i=0;i<nameSearch.length;i++) {
                    System.out.printf("아이디: %s\t이름: %s\n",nameSearch[i].getId(),nameSearch[i].getName());
                }
                break;
            case "10":
                System.out.println("전체회원수: "+control.getTotalMember()+"명");
                break;
            case "0":
                System.out.println("종료합니다.");
                scan.close();
                return;
            }
        }
    }
    
}
