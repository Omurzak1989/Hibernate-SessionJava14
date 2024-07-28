package peaksoft;

import peaksoft.entity.Course;
import peaksoft.enums.StudyFormat;
import peaksoft.service.CourseService;
import peaksoft.service.impl.CourseServiceImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        CourseService courseService=new CourseServiceImpl();


        courseService.saveCourse(new Course("Java",10000, StudyFormat.ONLINE));
        courseService.saveCourse(new Course("Java",14000, StudyFormat.OFFLINE));
        courseService.saveCourse(new Course("JS",10000, StudyFormat.ONLINE));
        courseService.saveCourse(new Course("JS",12000, StudyFormat.OFFLINE));
        courseService.saveCourse(new Course("Python",15000, StudyFormat.ONLINE));
        courseService.saveCourse(new Course("Python",10000, StudyFormat.OFFLINE));


//        List<Course> courses=courseService.getAllCourses();
//        courses.forEach(System.out::println);

//        Course course=courseService.getCourseById(1L);
//        System.out.println(course);

        String updateMessage= courseService.updateCourse(1L,new Course("Advanced java",20000,StudyFormat.ONLINE));
        System.out.println(updateMessage);

        String deleteMessage= courseService.deleteCourseById(2L);
        System.out.println(deleteMessage);



    }
}
