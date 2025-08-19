    package org.example.repository;

    import org.example.model.Student;

    import java.util.ArrayList;

    public class StudentRepository {
        private final ArrayList<Student> students = new ArrayList<>();

        public void initRepo(){
            students.add(new Student("A001","Guz", "002"));
            students.add(new Student("A002","Adricita999", "009"));
        }


        public ArrayList<Student> getStudents() {
            return students;
        }

        public void addStudent(Student student) {
            students.add(student);
        }
    }
