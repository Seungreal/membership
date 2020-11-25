package board.controllers;

import board.domains.StudentDTO;
import board.domains.TeacherDTO;
import board.domains.UserDTO;
import board.impls.UserServiceImpl;
import board.services.UserService;

public class UserController {
    UserService service;
    public UserController(){
        service = new UserServiceImpl();
    }
    public void postStudent(StudentDTO student){
        service.addStudent(student);
    }
    public void postTeacher(TeacherDTO teacher){
        service.addTeacher(teacher);
    }
    public void putUser(UserDTO user){
        service.updateUser(user);
    }
    public void deleteUser(UserDTO user){
        service.deleteUser(user);
    }
    public StudentDTO putLogin(StudentDTO student){
        return service.login(student);
    }
    public TeacherDTO putAccess(TeacherDTO teacher){
        return service.access(teacher);
    }
    public StudentDTO[] getStudentlist(){
        return service.fetchStudentlist();
    }
    public StudentDTO getStudentDetail(String username){
        return service.fetchStudentDetail(username);
    }
    public int getSum(StudentDTO student){
        return service.sum(student);
    }
    public float getAvg(int sum){
        return service.avg(sum);
    }
    public boolean getExistId(String username){
        return service.existId(username);
    }
}
