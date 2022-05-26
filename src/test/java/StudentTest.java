import Task4.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student s;

    @BeforeEach
    public void createNewStudent() {
        s = new Student();
    }

    @Test
    public void studentGroupShouldNotChangeWhenPassNull() {
        s.setGroup(null);
        Assertions.assertEquals("", s.getGroup());
    }

    @Test
    public void studentMarksShouldNotChangeWhenPassNull() {
        int[] marks = s.getMarks();
        s.setMarks(null);
        Assertions.assertEquals(marks, s.getMarks());
    }

    @Test
    public void studentMarksAverageShouldBeZero() {
        Assertions.assertEquals(0, s.getMarksAverage());
    }

    @Test
    public void ForNegativeSumOfMarksStudentMarksAverageShouldBeZero() {
        s.setMarks(new int[]{-50, -30, 10, -80, 40});
        Assertions.assertEquals(0, s.getMarksAverage());
    }

    @Test
    public void studentMarksAverageShouldCorrectPassOfAverage() {
        s.setMarks(new int[]{30, 41, 54, 44 ,31});
        Assertions.assertEquals((30 + 41 + 54 + 44 + 31) / 5., s.getMarksAverage());
    }

    @Test
    public void studentShouldBeExcellent() {
        s.setMarks(new int[]{91, 90, 90, 89}); //average = 90
        Assertions.assertEquals(true, s.isExcellentStudent());
    }

    @Test
    public void studentShouldNotBeExcellent() {
        s.setMarks(new int[]{89, 89, 89, 90}); //average = 89.25
        Assertions.assertEquals(false, s.isExcellentStudent());
    }

    @Test
    public void studentOneShouldBeBetterStudentByAverage() {
        Student s1 = new Student();
        s1.setMarks(new int[] {91, 91, 90, 90});

        Student s2 = new Student();
        s2.setMarks(new int[] {90, 90, 90, 90});

        Student s3 = new Student();
        s3.setMarks(new int[] {91, 90, 90, 90});

        Assertions.assertEquals(s1, Student.getBetterStudentByAverage(s1, s2, s3));
    }

    @Test
    public void studentTwoShouldBeBetterStudentByAverage() {
        Student s1 = new Student();
        s1.setMarks(new int[] {90, 90, 90, 90});

        Student s2 = new Student();
        s2.setMarks(new int[] {91, 91, 90, 90});

        Student s3 = new Student();
        s3.setMarks(new int[] {91, 90, 90, 90});

        Assertions.assertEquals(s2, Student.getBetterStudentByAverage(s1, s2, s3));
    }

    @Test
    public void studentThreeShouldBeBetterStudentByAverage() {
        Student s1 = new Student();
        s1.setMarks(new int[] {90, 90, 90, 90});

        Student s2 = new Student();
        s2.setMarks(new int[] {91, 90, 90, 90});

        Student s3 = new Student();
        s3.setMarks(new int[] {91, 91, 90, 90});

        Assertions.assertEquals(s3, Student.getBetterStudentByAverage(s1, s2, s3));
    }



}
