package Person;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Person {

    private String id;
    private String fullname;
    private String address;

    public Person(String id, String fullname, String address) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static class Student extends Person {

        private double gpa;
        private String major;
        private String studentId;

        public Student(String id, String fullname, String address, String studentId, String major, double gpa) {
            super(id, fullname, address);
            this.studentId = studentId;
            this.major = major;
            this.gpa = gpa;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public void displayDetails() {
            System.out.println("StudentId: " + studentId);
            System.out.println("Major: " + major);
            System.out.println("Gpa: " + gpa);
            System.out.println("Fullname: " + getFullname());
            System.out.println("Address: " + getAddress());
        }

        public static Student enterStudentList() {
            Scanner scanner = new Scanner(System.in);
            Student student = new Student(null, null, null, null, null, 0.0);

            System.out.println("Enter Student ID: ");
            String id = scanner.nextLine();
            student.setId(id);

            System.out.println("Enter Fullname: ");
            String fullname = scanner.nextLine();
            student.setFullname(fullname);

            System.out.println("Enter Address: ");
            String address = scanner.nextLine();
            student.setAddress(address);

            System.out.println("Enter GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());
            student.setGpa(gpa);

            System.out.println("Enter Major: ");
            String major = scanner.nextLine();
            student.setMajor(major);

            System.out.println("Enter Student Number (Student ID): ");
            String studentId = scanner.nextLine();
            student.setStudentId(studentId);

            return student;
        }

        @Override
        public String toString() {
            return "Student ID: " + studentId + ", Fullname: " + getFullname() + ", Address: " + getAddress() + ", GPA: " + gpa + ", Major: " + major;
        }
    }

    public static class StudentManagement {

        private ArrayList<Student> studentList = new ArrayList<>();

        public void addStudent(Student student) {
            studentList.add(student);
            System.out.println("Student added successfully.");
        }

        public void updateStudent(String id) {
            Scanner scanner = new Scanner(System.in);

            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    System.out.println("Enter new Fullname: ");
                    String fullname = scanner.nextLine();
                    student.setFullname(fullname);

                    System.out.println("Enter new Address: ");
                    String address = scanner.nextLine();
                    student.setAddress(address);

                    System.out.println("Enter new GPA: ");
                    double gpa = Double.parseDouble(scanner.nextLine());
                    student.setGpa(gpa);

                    System.out.println("Enter new Major: ");
                    String major = scanner.nextLine();
                    student.setMajor(major);

                    System.out.println("Student updated successfully.");
                    return;
                }
            }

            System.out.println("Student with ID " + id + " not found.");
        }

        public void deleteStudent(String id) {
            for (Student student : studentList) {
                if (student.getId().equals(id)) {
                    studentList.remove(student);
                    System.out.println("Student with ID " + id + " deleted successfully.");
                    return;
                }
            }

            System.out.println("Student with ID " + id + " not found.");
        }

        public static Person.Student findHighestGpaStudent(Person.StudentManagement management) {
            Person.Student topStudent = null;

          
            for (Person.Student student : management.getStudentList()) {
                
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }

            return topStudent;  
        }

        public void displayAllStudents() {
            if (studentList.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                for (Student student : studentList) {
                    System.out.println(student);
                }
            }
        }

        private Iterable<Student> getStudentList() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        Student s1 = new Student("001", "tu", "270 An Duong Vuong", "s1", "cntt", 3.5);
        Student s2 = new Student("002", "huy", "456 hung vuong", "S2", "It", 3.8);
        management.addStudent(s1);
        management.addStudent(s2);

        System.out.println("List of students:");
        management.displayAllStudents();

        System.out.println("Updating student with ID 001:");
        management.updateStudent("001");

        System.out.println("List of students after update:");
        management.displayAllStudents();

        System.out.println("Deleting student with ID 002:");
        management.deleteStudent("002");

        System.out.println("List of students after deletion:");
        management.displayAllStudents();
    }
}
