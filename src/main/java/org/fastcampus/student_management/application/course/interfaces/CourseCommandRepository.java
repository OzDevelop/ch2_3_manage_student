package org.fastcampus.student_management.application.course.interfaces;

import java.util.List;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;

public interface CourseCommandRepository {
    //interface에는 public이 안들어가도됨.
    void save(Course course);


}
