package org.fastcampus.student_management.application.course;

import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.course.interfaces.CourseCommandRepository;
import org.fastcampus.student_management.application.course.interfaces.CourseQueryRepository;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseCommandRepositoryImpl;
import org.fastcampus.student_management.repo.StudentRepository;

public class  CourseService {
  private final CourseCommandRepository courseCommandRepository;
  private final CourseQueryRepository courseQueryRepository;
  private final StudentRepository studentRepository;

  public CourseService(CourseCommandRepositoryImpl courseRepository, CourseQueryRepository courseQueryRepository, StudentRepository studentRepository) {
    this.courseCommandRepository = courseRepository;
    this.courseQueryRepository = courseQueryRepository;
    this.studentRepository = studentRepository;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentRepository.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto);
    courseCommandRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분
    List<Course> courses = CourseQueryRepository.getCourseDayOfWeek(dayOfWeek); // Course 정보 받기

    return courses.stream().map(CourseInfoDto::new).toList(); // 람다 형식 사용 시 이
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
    List<Course> courses = CourseQueryRepository.getCourseListByStudent(studentName);
    CourseList courseList = new CourseList(courses);

    courseList.changeAllCoursesFee(fee);
  }
}


