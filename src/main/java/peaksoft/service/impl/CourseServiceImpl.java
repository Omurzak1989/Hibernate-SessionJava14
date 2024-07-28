package peaksoft.service.impl;

import peaksoft.dao.CourseDao;
import peaksoft.dao.impl.CourseDaoImpl;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao=new CourseDaoImpl();
    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        return courseDao.updateCourse(courseId, newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public String deleteCourseById(Long courseId) {
        return courseDao.deleteCourseById(courseId);
    }
}
