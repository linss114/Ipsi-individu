
public class Main {
    public static void main(String[] args) {
// mata kuliah
        Course course = new Course();
        course.setTitle("Pemrograman Java");

// pertama
        Student student1 = new Student();
        student1.setName("Andi");

        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);

        Assignment assignment1 = new Assignment();
        assignment1.setMark(85);
        record1.addAssignment(assignment1);

        Assignment assignment2 = new Assignment();
        assignment2.setMark(90);
        record1.addAssignment(assignment2);

        course.addCourseRecord(record1);

//ini yang 2
        Student student2 = new Student();
        student2.setName("Budi");

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);

        Assignment assignment3 = new Assignment();
        assignment3.setMark(70);
        record2.addAssignment(assignment3);

        Assignment assignment4 = new Assignment();
        assignment4.setMark(75);
        record2.addAssignment(assignment4);

        course.addCourseRecord(record2);

//ini hasil
        System.out.println("Mata Kuliah: " + course.getTitle());
        System.out.println();

        course.printCourseStudents();
        System.out.println();

        course.printBestStudent();
        System.out.println();

        course.printFinalExamStudents();
    }
}
