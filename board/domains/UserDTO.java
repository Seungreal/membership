package board.domains;

public class UserDTO {
    private int userId;
    protected String username;
    protected String password;
    protected String nickname;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int id) {
        this.userId = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean equals(Object o) {
        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            if (userId == u.userId)
                return true;
        }
        return false;
    }
}
