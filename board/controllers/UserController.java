package board.controllers;

import java.util.ArrayList;
import board.domains.UserDTO;

public class UserController {
    private ArrayList<UserDTO> list;
    private int id = 4;

    public UserController() {
        list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            UserDTO u = new UserDTO();
            u.setId(i);
            u.setUsername("user" + i);
            u.setPassword("1");
            u.setNickname("사용자" + i);
            list.add(u);
        }
    }

    public UserDTO logIn(UserDTO logIn) {
        for (UserDTO u : list) {
            if (logIn.getUsername().equals(u.getUsername()) && logIn.getPassword().equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    // username 중복체크
    public boolean validateUsername(String username) {
        for (UserDTO u : list) {
            if (username.equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    // 회원가입
    public void register(UserDTO u) {
        u.setId(id++);
        list.add(u);
    }

    // 닉네임 리턴
    public String selectNickname(int id) {
        UserDTO u = new UserDTO();
        u.setId(id);

        int index = list.indexOf(u);
        if (index != -1) {
            return list.get(index).getNickname();
        }
        return "손님";
    }
}
