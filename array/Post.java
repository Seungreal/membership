package array;

import java.util.Calendar;

public class Post {
    private int number;
    private String subject;
    private String contents;
    private String writer;
    private Calendar writtenDate;
    private Calendar updatedDate;

    public String toString() {
        //객체의 필드값을 출력하는 방법은 다양하다
        return "글 번호: " + number + ", 글 제목: " + subject + ", 내용: " + contents + ", 작성자: " + writer;
    }

    public boolean equals(Object o) {
        if (o instanceof Post) {
            Post p = (Post) o;
            if (this.number == p.number && this.subject == p.subject)
                return true;
        }

        return false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    public Calendar getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }

    public Calendar getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
    }

}
