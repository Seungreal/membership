package membership;

public class UserServiceImpl implements UserService {
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
