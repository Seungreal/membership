package board;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import board.controllers.*;
import board.domains.*;

public class Applicaton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf;
        ArticleController articleController = new ArticleController();
        UserController userController = new UserController();
        StudentDTO student;
        TeacherDTO teacher;
        ArticleDTO article;
        ReplyDTO reply;
        String title = "비트 성적관리 프로그램\n";
        String navi = "[학생 UI]\n"
        +"01. 학생등록, 02. 아이디중복체크, 03. 학생로그인, 04. 학생정보수정, 05. 학생정보삭제 \n"
        +"[강사 UI]\n"
        +"11. 강사등록, 12. 강사접속, 13. 학생목록보기, 14. 학생상세정보, 15. 성적합계, 16.성적평균\n"
        +"[게시판 UI]\n"
        +"21. 새글 작성 22. 글 목록 23. 글 상세 24. 글 수정 25.글 삭제\n"
        +"26. 댓글 쓰기 27. 댓글 보기 \n"
        +"0. 종료 \n > ";
        while(true){
            System.out.println(title+navi);
            switch(scanner.next()){
                case "1": 
                    System.out.println("username,password,nickname을 입력하세요.");
                    student = new StudentDTO(scanner.next(),scanner.next(),scanner.next());
                    userController.postStudent(student);
                    break;
                case "2":
                    System.out.println("username을 입력하세요");
                    String username = scanner.next();
                    if(userController.getExistId(username)){
                        System.out.println("중복된 username입니다.");
                    }else{
                        System.out.println("사용가능한 username입니다.");
                    }
                    break;
                case "3": 
                    student = new StudentDTO();
                    System.out.println("username,password를 입력하세요");
                    student.setUsername(scanner.next());
                    student.setPassword(scanner.next());
                    userController.putLogin(student);
                    break;
                case "4":
                    break;
                case "5": 
                    student = new StudentDTO();
                    System.out.println("username,password를 입력하세요");
                    student.setUsername(scanner.next());
                    student.setPassword(scanner.next());
                    userController.deleteUser(student);
                    break;
                case "11": 
                    teacher = new TeacherDTO();
                    System.out.print("username을 입력하세요\n>");
                    teacher.setUsername(scanner.next());
                    System.out.print("password을 입력하세요\n>");
                    teacher.setPassword(scanner.next());
                    System.out.print("nickname을 입력하세요\n>");
                    teacher.setNickname(scanner.next());
                    System.out.print("accessKey을 입력하세요\n>");
                    teacher.setAcessKey(scanner.next());
                    userController.postTeacher(teacher);
                    break;
                case "12": 
                    teacher = new TeacherDTO();
                    System.out.println("username,password,accesskey를 입력하세요");
                    teacher.setUsername(scanner.next());
                    teacher.setPassword(scanner.next());
                    teacher.setAcessKey(scanner.next());
                    userController.putAccess(teacher);
                    break;
                case "13": 
                    StudentDTO[] studentList = userController.getStudentlist();
                    for(int i=0;i<studentList.length;i++){
                        System.out.printf("%d. %s\n", studentList[i].getUserId(), studentList[i].getUsername());
                    }
                    break;
                case "14": 
                    System.out.println("username을 입력하세요");
                    student = userController.getStudentDetail(scanner.next());
                    System.out.println(student);
                    break;
                case "15": 
                    break;
                case "16":
                    break;
                case "21": 
                    article = new ArticleDTO();
                    System.out.print("제목: ");
                    article.setTitle(scanner.next());
                    System.out.print("내용: ");
                    article.setContent(scanner.next());
                    articleController.postArticle(article);
                    break;
                case "22": 
                    ArticleDTO[] articleList = articleController.getArticleList();
                    for(int i=0;i<articleList.length;i++){
                        System.out.printf("%d. %s\t%s\n",articleList[i].getArtId(),
                        articleList[i].getTitle(),articleList[i].getWriterId());
                    }
                    break;
                case "23": 
                    System.out.print("상세보기할 글 번호를 적어주세요: ");
                    article = articleController.getArticle(scanner.nextInt());
                    sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    System.out.println("제목:" + article.getTitle());
                    System.out.println("작성자: " + article.getWriterId());
                    System.out.println("작성일:" + sdf.format(article.getWrittenDate().getTime()));
                    System.out.println("수정일:" + sdf.format(article.getUpdatedDate().getTime()));
                    System.out.println("----------------------");
                    System.out.println(article.getContent());
                    break;
                case "24": 
                    article = new ArticleDTO();
                    System.out.print("수정할 글 번호를 적어주세요: ");
                    article.setArtId(scanner.nextInt());
                    System.out.print("제목:");
                    article.setTitle(scanner.next());
                    System.out.print("내용:");
                    article.setContent(scanner.next());
                    articleController.putArticle(article);
                    break;
                case "25": 
                    System.out.print("삭제할 글 번호를 적어주세요: ");
                    articleController.deleteArticle(scanner.nextInt());
                    break;
                case "26": 
                    reply = new ReplyDTO();
                    System.out.print("내용");
                    reply.setContent(scanner.next());
                    articleController.postReply(reply);
                    break;
                case "27": 
                    System.out.print("댓글을 볼 글 번호를 적어주세요: ");
                    ReplyDTO[] replyList=articleController.getReply(scanner.nextInt());
                    sdf = new SimpleDateFormat("y-M-d H:m:s");
                    for(int i=0;i<replyList.length;i++){
                        if(replyList[i]!=null){
                            System.out.println("-----------------------");
                            System.out.printf("%s\t%s\n", replyList[i].getWriterId(),
                            sdf.format(replyList[i].getWrittenDate().getTime()));
                            System.out.println("-----------------------");
                            System.out.printf(replyList[i].getContent());
                        }
                    }
                    break;    
                case "0":
                    System.out.println("종료합니다.");
                    scanner.close();
                    return;
            }
        }
    }
}