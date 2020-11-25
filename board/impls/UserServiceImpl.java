package board.impls;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;
import board.domains.UserDTO;
import board.services.UserService;

public class UserServiceImpl implements UserService {
    private StudentDTO[] studentList;
    private TeacherDTO[] teacherList;
    int userId;
    public UserServiceImpl(){
        studentList = new StudentDTO[0];
        teacherList = new TeacherDTO[0];
        userId=1;
    }

    @Override
    public void addStudent(StudentDTO student) {
        int size = studentList.length;
        StudentDTO[] temp = new StudentDTO[size+1];
        for(int i=0;i<size;i++){
            temp[i]=studentList[i];
        }
        student.setUserId(userId++);
        temp[size]=student;
        studentList=temp;
    }

    @Override
    public void addTeacher(TeacherDTO teacher) {
        int size = teacherList.length;
        TeacherDTO[] temp = new TeacherDTO[size+1];
        for(int i=0;i<size;i++){
            temp[i]=teacherList[i];
        }
        temp[size]=teacher;
        teacherList=temp;
    }

    @Override
    public void updateUser(UserDTO user) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteUser(UserDTO user) {
        int size = studentList.length;
        int index=-1;
        for(int i=0;i<size;i++){
            if(user.getUsername().equals(studentList[i].getUsername()) && 
            user.getPassword().equals(studentList[i].getPassword())){
                index=i;
                break;
            }
        }
        if(index!=-1){
            StudentDTO[] temp = new StudentDTO[size-1];
            for(int i=0;i<index;i++){
                temp[i]=studentList[i];
            }
            for(int i=index;i<size-1;i++){
                temp[i]=studentList[i+1];
            }
            studentList=temp;
        }
    }

    @Override
    public StudentDTO login(StudentDTO student) {
        for(int i=0;i<studentList.length;i++){
            if(student.getUsername().equals(studentList[i].getUsername()) && 
            student.getPassword().equals(studentList[i].getPassword())){
                return studentList[i];
            }
        }
        return null;
    }

    @Override
    public TeacherDTO access(TeacherDTO teacher) {
        for(int i=0;i<teacherList.length;i++){
            if(teacher.getUsername().equals(teacherList[i].getUsername()) &&
            teacher.getPassword().equals(teacherList[i].getPassword()) &&
            teacher.getAcessKey().equals(teacherList[i].getAcessKey())){
                return teacherList[i];
            }
        }
        return null;
    }

    @Override
    public StudentDTO[] fetchStudentlist() {
        return studentList;
    }

    @Override
    public StudentDTO fetchStudentDetail(String username) {
        for(int i=0;i<studentList.length;i++){
            if(username.equals(studentList[i].getUsername())){
                return studentList[i];
            }
        }
        return null;
    }

    @Override
    public int sum(StudentDTO student) {
        return student.getKor()+student.getEng()+student.getMath();
    }

    @Override
    public float avg(int sum) {
        return sum/3.0f;
    }

    @Override
    public boolean existId(String username) {
        boolean result = false;
        for(int i=0;i<studentList.length;i++){
            if(username.equals(studentList[i].getUsername())){
                result=true;
            }
        }
        return result;
    }
    
}
