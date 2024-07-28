package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseDao {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    String updateCourse(Long courseId, Course newCourse);
    List<Course> getAllCourses();
    String deleteCourseById(Long courseId);

}
