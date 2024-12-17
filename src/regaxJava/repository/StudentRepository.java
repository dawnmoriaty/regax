package regaxJava.repository;

import regaxJava.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final String FILE_PATH = "D:\\classJava+Thanh\\untitled\\src\\regaxJava\\data\\studentsdata.txt";
    private static List<Student> students;
    static {
        students = util.FileIO.readFromFile(FILE_PATH);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void update(Student student) {
        Student existingStudent = findById(student.getId());
        if (existingStudent != null) {
            int index = students.indexOf(existingStudent);
            students.set(index, student);
            util.FileIO.writeToFile(FILE_PATH, students);
            System.out.println("Thông tin sinh viên đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + student.getId());
        }
    }

    @Override
    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Student student) {
        if(findById(student.getId())==null){
            students.add(student);
        }else{
            students.set(students.indexOf(findById(student.getId())),student);
        }
        util.FileIO.writeToFile(FILE_PATH, students);
    }

    @Override
    public void deleteById(int id) {
        if(findById(id)!=null){
            students.remove(findById(id));
            util.FileIO.writeToFile(FILE_PATH,students);
        }
    }
}
