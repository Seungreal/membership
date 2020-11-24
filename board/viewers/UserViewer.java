package board.viewers;

import java.util.Scanner;

import util.ScannerUtil;
import board.controllers.UserController;
import board.domains.UserDTO;

public class UserViewer {
    private Scanner scan;
    private UserController userController;

    public UserViewer() {
        scan = new Scanner(System.in);
        userController = new UserController();
    }

    // 메뉴 출력
    public UserDTO showMain() {
        while (true) {
            UserDTO logIn = new UserDTO();
            String message = "1. 로그인 2.회원가입 3. 종료";
            int userChoice = ScannerUtil.nextInt(scan, message, 1, 3);
            if (userChoice == 1) {
                logIn = logIn();
                if (logIn == null) {
                    break;
                }

                System.out.println(logIn.getNickname() + "님 환영합니다!");

                return logIn;
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                // System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

        return null;
    }

    private UserDTO logIn() {
        UserDTO logIn = new UserDTO();
        System.out.print("username(종료를 원하시면 x를 입력하세요):");
        logIn.setUsername(ScannerUtil.nextLine(scan));
        if (logIn.getUsername().toLowerCase().equals("x"))
            return null;
        System.out.print("password: ");
        logIn.setPassword(ScannerUtil.nextLine(scan));

        while (userController.logIn(logIn) == null) {
            System.out.println("잘못된 정보입니다.");

            System.out.print("username(종료를 원하시면 x를 입력하세요):");
            logIn.setUsername(ScannerUtil.nextLine(scan));
            if (logIn.getUsername().toLowerCase().equals("x"))
                return null;
            System.out.print("pw:");
            logIn.setPassword(ScannerUtil.nextLine(scan));
        }

        return userController.logIn(logIn);
    }

    private void register() {
        UserDTO u = new UserDTO();

        System.out.print("username: ");
        u.setUsername(ScannerUtil.nextLine(scan));

        while (userController.validateUsername(u.getUsername())) {
            System.out.println("중복된 username입니다. 다시 입력해주세요");
            System.out.print("username: ");
            u.setUsername(ScannerUtil.nextLine(scan));
        }
        System.out.print("pw:");
        u.setPassword(ScannerUtil.nextLine(scan));
        System.out.print("nickname:");
        u.setNickname(ScannerUtil.nextLine(scan));

        userController.register(u);
    }

    public String selectNicknameById(int id) {
        return userController.selectNickname(id);
    }
}
