package board.services;

import board.domains.StudentDTO;
import board.domains.UserDTO;
import board.domains.TeacherDTO;

public interface UserService {
    public void addStudent(StudentDTO student);
    public void addTeacher(TeacherDTO teacher);
    public void updateUser(UserDTO user);
    public void deleteUser(UserDTO user);
    public StudentDTO login(StudentDTO student);
    public TeacherDTO access(TeacherDTO teacher);
    public StudentDTO[] fetchStudentlist();
    public StudentDTO fetchStudentDetail(String username);
    public int sum(StudentDTO student);
    public float avg(int sum);
    public boolean existId(String username);
}
