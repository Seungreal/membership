package membership;
/*
(1)회원가입 
(2)로그인 
(3)비밀번호 수정 
(4)회원탈퇴 
(5)아이디 중복체크 
(6)마이페이지 
(7)회원목록 
(8)아이디검색 
(9)이름검색
(10)전체 회원수
 */
public interface UserService {
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
