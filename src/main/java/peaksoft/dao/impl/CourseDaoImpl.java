package peaksoft.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import peaksoft.config.HibernetConfig;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory= HibernetConfig.getEntityManagerFactory();

    @Override
    public String saveCourse(Course course) {
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        try {
            entityManager=entityManagerFactory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(course);
            transaction.commit();
            return "Course saved successfully";

        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            return e.getMessage();
        }finally {
            if(transaction!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        EntityManager entityManager=null;
        try {
            entityManager=entityManagerFactory.createEntityManager();
            return entityManager.find(Course.class, courseId);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        try {
            entityManager=entityManagerFactory.createEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            Course course=entityManager.find(Course.class, courseId);
           if (course!=null){
               course.setCourseName(newCourse.getCourseName());
               course.setPrice(newCourse.getPrice());
               course.setStudyFormat(newCourse.getStudyFormat());
               entityManager.merge(course);
               transaction.commit();
               return "Course updated successfully";
           }else {
               return "Course not found";
           }

        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            return e.getMessage();
        }finally {
            if(transaction!=null){
                entityManager.close();
            }
        }

    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager=null;
        try {
            entityManager=entityManagerFactory.createEntityManager();
            return entityManager.createQuery("from Course",Course.class).getResultList();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            if (entityManager!=null){
                entityManager.close();
            }
        }
    }

    @Override
    public String deleteCourseById(Long courseId) {
      EntityManager entityManager=null;
      EntityTransaction transaction=null;
      try {
          entityManager=entityManagerFactory.createEntityManager();
          transaction=entityManager.getTransaction();
          transaction.begin();
          Course course=entityManager.find(Course.class, courseId);
          if (course!=null){
              entityManager.remove(course);
              transaction.commit();
              return "Course deleted successfully";
          }else {
              return "Course not found";
          }
      }catch (HibernateException e){
          if(transaction!=null){
              transaction.rollback();
          }
          return e.getMessage();
      }finally {
          if(transaction!=null){
              entityManager.close();
          }
      }
    }
}
