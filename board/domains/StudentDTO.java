package board.domains;

public class StudentDTO extends UserDTO{
    private int kor,eng,math;
    public StudentDTO(){}
    public StudentDTO(String username,String password,String nickname){
        super.username=username;
        super.password=password;
        super.nickname=nickname;
    }
    public int getKor() {return kor;}
    public void setKor(int kor) {this.kor = kor;}
    public int getEng() {return eng;}
    public void setEng(int eng) {this.eng = eng;}
    public int getMath() {return math;}
    public void setMath(int math) {this.math = math;}
    @Override
    public String toString() {
        return "성적 [nickname="+super.getNickname()+", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
    }
}
