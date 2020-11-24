package board.viewers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import util.ScannerUtil;
import board.controllers.ReplyController;
import board.domains.ReplyDTO;

public class ReplyViewer {
    private ReplyController controller;
    private Scanner scan;
    private int id = 1;

    public ReplyViewer() {
        controller = new ReplyController();
        scan = new Scanner(System.in);
    }

    // 해당 글의 댓글을 출력하는 메소드
    public void printAll(int boardId, UserViewer userViewer) {
        ArrayList<ReplyDTO> list = controller.selectByBoardId(boardId);
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
        for (ReplyDTO r : list) {
            System.out.println("-----------------------");
            System.out.printf("%s\t%s\n", userViewer.selectNicknameById(r.getWriterId()),
                    sdf.format(r.getWrittenDate().getTime()));
            System.out.println("-----------------------");
            System.out.printf(r.getContent());
            System.out.println();
        }
    }

    // 해당 글에 댓글을 작성하는 메소드
    public void writeReply(int boardId, int writerId) {
        ReplyDTO r = new ReplyDTO();
        r.setId(id++);
        r.setWrittenDate(Calendar.getInstance());
        r.setBoardId(boardId);
        r.setWriterId(writerId);
        System.out.print("댓글 내용:");
        r.setContent(ScannerUtil.nextLine(scan));

        controller.insert(r);
    }
}
