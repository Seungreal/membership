package abstraction;

import java.util.Scanner;
public class UserApp {
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
class UserDTO {
    private String id,password,name;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    @Override
    public String toString() {
        return "[id=" + id + ", password=" + password + ", name=" + name + "]";
    }
}
interface UserService {
    public void join(UserDTO user);
    public UserDTO login(UserDTO user);
    public void updatePassword(UserDTO user);
    public void withdrwal(UserDTO user);
    public boolean checkId(String id);
    public UserDTO myPage(UserDTO user);
    public UserDTO[] memberList();
    public UserDTO idSearch(String id);
    public UserDTO[] nameSearch(String name);
    public int totalMember();
}
class UserServiceImpl implements UserService {
    private UserDTO[] users;
    private int count;

    public UserServiceImpl() {
        users = new UserDTO[3];
        count = 0;
    }

    @Override
    public void join(UserDTO user) {
        users[count] = user;
        count++;
    }

    @Override
    public UserDTO login(UserDTO user) {
        UserDTO result = null;
        for (int i = 0; i < count; i++) {
            if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
                result = users[i];
                break;
            }
        }
        return result;
    }

    @Override
    public void updatePassword(UserDTO user) {
        for(int i = 0; i < count; i++) {
            if(user.getId().equals(users[i].getId())) {
                users[i].setPassword(user.getPassword());
                break;
            }
        }
    }

    @Override
    public void withdrwal(UserDTO user) {
        for(int i=0 ;i<count;i++) {
            if(user.getId().equals(users[i].getId()) &&
                    user.getPassword().equals(users[i].getPassword())){
                users[i] = users[count-1];
                users[count-1] = null;
                count--;
                break;
            }
        }
    }

    @Override
    public boolean checkId(String id) {
        boolean check = true;
        for(int i=0;i<count;i++) {
            if(id.equals(users[i].getId())) {
                check=false;
                break;
            }
        }
        return check;
    }

    @Override
    public UserDTO myPage(UserDTO user) {
        UserDTO result = null;
        for (int i = 0; i < count; i++) {
            if (user.getId().equals(users[i].getId()) && user.getPassword().equals(users[i].getPassword())) {
                result = users[i];
                break;
            }
        }
        return result;
    }

    @Override
    public UserDTO[] memberList() {
        return users;
    }

    @Override
    public UserDTO idSearch(String id) {
        for(int i=0;i<count;i++) {
            if(id.equals(users[i].getId())) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public UserDTO[] nameSearch(String name) {
        UserDTO[] byName = new UserDTO[0];
        for(int i=0;i<count;i++) {
            if(name.equals(users[i].getName())) {
                UserDTO[] temp = byName;
                byName = new UserDTO[temp.length+1];
                for(int j=0;j<temp.length;j++) {
                    byName[j]=temp[j];
                }
                byName[temp.length]=users[i];
            }
        }
        return byName;
    }

    @Override
    public int totalMember() {
        return count;
    }

}
class UserController {
    UserService service;
    public UserController() {
        service = new UserServiceImpl();
    }
    public void PostJoin(UserDTO user) {
        service.join(user);
    }
    public UserDTO postLogin(UserDTO user) {
        return service.login(user);
    }
    public void putPassword(UserDTO user) {
        service.updatePassword(user);
    }
    public void deleteUser(UserDTO user) {
        service.withdrwal(user);
    }
    public boolean getCheckId(String id) {
        return service.checkId(id);
    }
    public UserDTO getMyPage(UserDTO user) {
        return service.myPage(user);
    }
    public UserDTO[] getMemberList() {
        return service.memberList();
    }
    public UserDTO getIdSearch(String id) {
        return service.idSearch(id);
    }
    public UserDTO[] getNameSearch(String name) {
        return service.nameSearch(name);
    }
    public int getTotalMember() {
        return service.totalMember();
    }
}
interface UserDAO {
    public void insertUser(UserDTO user);
    public UserDTO login(UserDTO user);
    public void updatePassword(UserDTO user);
    public void deleteUser(UserDTO user);
    public boolean selectCheckId(String id);
    public UserDTO selectUser(UserDTO user);
    public UserDTO[] selectUserList();
    public UserDTO selectById(String id);
    public UserDTO[] selectByName(String name);
    public int selectCount();
}
class UserDAOImpl implements UserDAO{

    @Override
    public void insertUser(UserDTO user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserDTO login(UserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updatePassword(UserDTO user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteUser(UserDTO user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean selectCheckId(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserDTO selectUser(UserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO[] selectUserList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO selectById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO[] selectByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int selectCount() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}