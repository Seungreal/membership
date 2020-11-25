package array;

//게시판관리등에서
//로그인하는 회원을 담당하는 Member클래스
public class Member {
    private int id;
    private String userName;
    private String password;
    private String nickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean equals(Object o) {
        if (o instanceof Member) {
            Member m = (Member) o;
            if (userName.equals(m.userName) && password.equals(m.password))
                return true;
        }

        return false;
    }
    
    public String toString() {
        return "id: "+id+
                ", userName: "+userName+
                ", password: "+password+
                ", nickName: "+nickName;
    }

    public Member() {
        userName = new String();
        password = new String();
        nickName = new String();
    }

    public Member(int id, String userName, String password, String nickName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }
}
