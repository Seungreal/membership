package board.domains;

public class ReplyDTO extends ArticleDTO{
    private int replyId;
    private int boardId;

    public int getReplyId() {
        return replyId;
    }
    public void setReplyId(int id) {
        this.replyId = id;
    }
    public int getBoardId() {
        return boardId;
    }
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    /*public boolean equals(Object o) {
        if (o instanceof ReplyDTO) {
            ReplyDTO r = (ReplyDTO) o;
            if (id == r.id)
                return true;
        }
        return false;
    }*/
}
