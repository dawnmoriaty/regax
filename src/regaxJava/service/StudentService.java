package regaxJava.service;
import regaxJava.model.Student;
import regaxJava.repository.StudentRepository;
import regaxJava.utils.InputMethods;
import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }
    public void displayAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            System.out.println("--------------------DANH SÁCH RỖNG ---------------------");
        } else {
            System.out.println("\nThông tin sinh viên:");
            System.out.printf("| %-3s | %-15s | %-25s | %-5s | %-10s | %-25s | %-15s | %-10s | %-10s | %-10s | | %-10s | |%-20s|\n",
                    "ID", "Name", "Email", "Age", "Gender", "Address", "Phone", "Status", "Math", "English", "Literature","birthday");
            for (Student student : students) {
                student.displayStudentInfo();
            }
        }
    }

    public void addNewStudent() {
        System.out.println("Nhập số lượng học sinh cần thêm mới:");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            Student newStudent = Student.inputStudentInfo();
            studentRepository.save(newStudent);
            System.out.println("==============CREATE========================");
            System.out.println("Sinh viên thứ " + (i + 1) + " đã được thêm vào.");
        }
    }
    public void deleteStudent() {
        System.out.println("Nhap vao id cần xóa");
        int id = InputMethods.getInteger();
        if(studentRepository.findById(id)==null) {
            System.out.println("Không tìm thấy sinh viên");
        }
        else {
            studentRepository.deleteById(id);
            System.out.println("============Delete==================");
        }
    }
    public void updateStudent() {
        System.out.println("Nhập vào ID cần cập nhật:");
        int id = InputMethods.getInteger();
        Student existingStudent = studentRepository.findById(id);
        if (existingStudent == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        } else {
            System.out.println("Thông tin sinh viên hiện tại: ");
            existingStudent.displayStudentInfo();
            System.out.println("Nhập thông tin mới để cập nhật:");
            Student updatedStudent = Student.inputStudentInfo();
            updatedStudent.setId(id);
            studentRepository.update(updatedStudent);
            System.out.println("==============UPDATE==================");
        }
    }




}


