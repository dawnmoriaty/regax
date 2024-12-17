package regaxJava.repository;

import regaxJava.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void deleteById(int id);
    void update(Student student);

}
