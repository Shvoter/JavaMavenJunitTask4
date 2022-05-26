package Task4;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Student extends Person {
    private String group = "";
    int[] marks = {};

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setGroup(String group) {
        if (group != null)
            this.group = group;
    }

    public void setMarks(int[] marks) {
        if (marks != null)
            this.marks = marks;
    }

    public double getMarksAverage() {

        if(marks.length == 0)
            return 0;

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum >= 0 ? sum / Double.valueOf(marks.length) : 0;
    }

    public boolean isExcellentStudent() {
        return getMarksAverage() >= 90;
    }

    public static Student getBetterStudentByAverage(Student student1, Student student2, Student student3) {
        double markAverageOfStudent1 = student1.getMarksAverage();
        double markAverageOfStudent2 = student2.getMarksAverage();
        double markAverageOfStudent3 = student3.getMarksAverage();

        if (markAverageOfStudent1 > markAverageOfStudent2) {
            if (markAverageOfStudent1 > markAverageOfStudent3) {
                return student1;
            } else
                return student3;
        } else if (markAverageOfStudent3 > markAverageOfStudent2) {
            return student3;
        } else {
            return student2;
        }
    }
}
