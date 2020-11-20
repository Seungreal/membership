package membership;

public interface UserDAO {
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
