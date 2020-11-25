package board.domains;

public class TeacherDTO extends UserDTO{
    private String acessKey;
    public void setAcessKey(String key){acessKey=key;}
    public String getAcessKey(){return acessKey;}
}