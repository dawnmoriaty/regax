package regaxJava.model;

import regaxJava.utils.InputMethods;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String fullName;
    private String email;
    private int age;
    private GENDER gender;
    private String address;
    private String phone;
    private boolean status;
    private double pointMath;
    private double pointEnglish;
    private double pointLiterature;
    private Date dateOfBirth;

    public Student() {
    }

    public Student(int id, String fullName, String email, int age, GENDER gender, String address, String phone, boolean status, double pointMath, double pointEnglish, double pointLiterature, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.pointMath = pointMath;
        this.pointEnglish = pointEnglish;
        this.pointLiterature = pointLiterature;
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPointMath() {
        return pointMath;
    }

    public void setPointMath(double pointMath) {
        this.pointMath = pointMath;
    }

    public double getPointEnglish() {
        return pointEnglish;
    }

    public void setPointEnglish(double pointEnglish) {
        this.pointEnglish = pointEnglish;
    }

    public double getPointLiterature() {
        return pointLiterature;
    }

    public void setPointLiterature(double pointLiterature) {
        this.pointLiterature = pointLiterature;
    }
    public static Student inputStudentInfo() {
        Student student = new Student();
        System.out.print("Nhập ID sinh viên: ");
        student.setId(InputMethods.getInteger());
        System.out.print("Nhập tên sinh viên: ");
        student.setFullName(InputMethods.getString());
        while (true) {
            System.out.print("Nhập email sinh viên: ");
            String email = InputMethods.getString();
            if (isValidEmail(email)) {
                student.setEmail(email);
                break;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.print("Nhập tuổi sinh viên: ");
        student.setAge(InputMethods.getInteger());
        while (true) {
            System.out.print("Nhập giới tính (1: MALE, 2: FEMALE, 3: OTHER): ");
            int genderChoice = Integer.parseInt(InputMethods.getString());
            if (genderChoice == 1) {
                student.setGender(GENDER.MALE);
                break;
            } else if (genderChoice == 2) {
                student.setGender(GENDER.FEMALE);
                break;
            } else if (genderChoice == 3) {
                student.setGender(GENDER.OTHER);
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.print("Nhập địa chỉ sinh viên: ");
        student.setAddress(InputMethods.getString());

        // Nhập số điện thoại sinh viên (kiểm tra số điện thoại hợp lệ)
        while (true) {
            System.out.print("Nhập số điện thoại sinh viên: ");
            String phone = InputMethods.getString();
            if (isValidPhoneNumber(phone)) {
                student.setPhone(phone);
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ ở việt nam. Vui lòng nhập lại.");
            }
        }
        while (true) {
            System.out.print("Sinh viên có đi học không? (1: Đi học, 2: Không đi học): ");
            int statusChoice = InputMethods.getInteger();
            if (statusChoice == 1) {
                student.setStatus(true); // Đi học
                break;
            } else if (statusChoice == 2) {
                student.setStatus(false); // Không đi học
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.print("Nhập điểm môn Toán: ");
        student.setPointMath(InputMethods.getDouble());
        System.out.print("Nhập điểm môn Tiếng Anh: ");
        student.setPointEnglish(InputMethods.getDouble());
        System.out.print("Nhập điểm môn Ngữ văn: ");
        student.setPointLiterature(InputMethods.getDouble());
        String dateOfBirthString;
        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            dateOfBirthString = InputMethods.getString();
            if (isValidDate(dateOfBirthString)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dateOfBirth = dateFormat.parse(dateOfBirthString); // Chuyển đổi chuỗi thành Date
                    student.setDateOfBirth(dateOfBirth);
                    break;
                } catch (ParseException e) {
                    System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
            }
        }

        return student;
    }

    // Kiểm tra email hợp lệ bằng Regex
    private static boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Kiểm tra số điện thoại hợp lệ bằng Regex (Giả sử số điện thoại có 10 chữ số)
    private static boolean isValidPhoneNumber(String phone) {
        String phonePattern = "^(0[3-9])\\d{8}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    private static boolean isValidDate(String date) {
        String datePattern = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public void displayStudentInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateOfBirth = dateFormat.format(this.getDateOfBirth());
        System.out.printf("| %-3d | %-15s | %-25s | %-5d | %-10s | %-25s | %-15s | %-10s | %-10.2f | %-10.2f | %-10.2f | %-12s |\n",
                this.getId(),
                this.getFullName(),
                this.getEmail(),
                this.getAge(),
                this.getGender(),
                this.getAddress(),
                this.getPhone(),
                this.isStatus() ? "Đi học" : "Không đi học",
                this.getPointMath(),
                this.getPointEnglish(),
                this.getPointLiterature(),
                formattedDateOfBirth);
    }
}
