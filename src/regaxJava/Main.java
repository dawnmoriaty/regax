package regaxJava;

import regaxJava.service.StudentService;
import regaxJava.utils.InputMethods;

public class Main {
    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        int choice = -1;  // Khởi tạo lựa chọn không hợp lệ ban đầu

        // Lặp vô hạn cho đến khi người dùng chọn thoát
        while (choice != 5) {
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add a student");
            System.out.println("2. Update a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Nhận đầu vào từ người dùng
            choice = InputMethods.getInteger();

            switch (choice) {
                case 1:
                    studentService.addNewStudent();
                    break;
                case 2:
                    studentService.updateStudent();
                    break;
                case 3:
                    studentService.deleteStudent();
                    break;
                case 4:
                    studentService.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
