
import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        // Cetak seluruh mahasiswa yang mengambil mata kuliah
        Enumeration<CourseRecord> records = getCourseRecords();

        System.out.println("Daftar Mahasiswa:");

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();

            if (student != null) {
                System.out.println(student.getName());
            }
        }
    }

    public void printBestStudent() {
        // Cetak mahasiswa dengan nilai rata-rata terbaik
        Enumeration<CourseRecord> records = getCourseRecords();

        String bestStudent = null;
        double bestAverage = -1;

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();

            if (student == null) {
                continue;
            }

            Enumeration<Assignment> assignments =
                    cr.getAssignments();

            double total = 0;
            int count = 0;
            boolean valid = true;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();

                try {
                    total += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    valid = false;
                    break;
                }
            }

            if (valid && count > 0) {
                double average = total / count;

                if (average > bestAverage) {
                    bestAverage = average;
                    bestStudent = student.getName();
                }
            }
        }

        if (bestStudent != null) {
            System.out.println("Mahasiswa Terbaik: " + bestStudent);
            System.out.println("Nilai Rata-rata: " + bestAverage);
        } else {
            System.out.println("Belum ada nilai lengkap.");
        }
    }

    public void printFinalExamStudents() {
        // Cetak mahasiswa yang memenuhi syarat ujian akhir
        Enumeration<CourseRecord> records = getCourseRecords();

        System.out.println("Mahasiswa Layak Ujian Akhir:");

        while (records.hasMoreElements()) {
            CourseRecord cr = records.nextElement();
            Student student = cr.getStudent();

            if (student == null) {
                continue;
            }

            Enumeration<Assignment> assignments =
                    cr.getAssignments();

            double total = 0;
            int count = 0;
            boolean valid = true;

            while (assignments.hasMoreElements()) {
                Assignment assignment = assignments.nextElement();

                try {
                    total += assignment.getMark();
                    count++;
                } catch (NotYetSetException e) {
                    valid = false;
                    break;
                }
            }

            if (valid && count > 0) {
                double average = total / count;

                // Asumsi sementara: nilai rata-rata minimal 60
                if (average >= 60) {
                    System.out.println(
                            student.getName()
                            + " - Rata-rata: " + average
                    );
                }
            }
        }
    }
}
