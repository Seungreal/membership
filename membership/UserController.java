package membership;

public class UserController {
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
