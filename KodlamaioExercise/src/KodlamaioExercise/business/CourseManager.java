package KodlamaioExercise.business;

import KodlamaioExercise.core.logging.Logger;
import KodlamaioExercise.dataAccess.CourseDao;
import KodlamaioExercise.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    List<Course> allCourses = new ArrayList<>();
    private List<Logger> loggers;
    public CourseManager(CourseDao dao , List<Logger> loggers) {
        this.courseDao = dao;
        this.loggers = loggers;
    }

    public void add(Course course) throws Exception {
        if (isCourseAlreadyAdded(course) ) {
            throw new Exception("Bu kurs daha önce satın alındı: " + course.getName());
        }else if(course.getUnitPrice() < 0 ){
            throw new Exception("Kursun fiyatı 0 dan küçük olamaz! ");
        }
        else {
            allCourses.add(course);
            courseDao.add(course);
            System.out.println("Eklenen Kurs : " + course.getId() + " - " + course.getName());

        }
        for (Logger allLoggers:loggers) {
            allLoggers.log(course.getName());
        }

    }

    private boolean isCourseAlreadyAdded(Course course) {
        for (Course existingCourse : allCourses) {
            if (existingCourse.equals(course)) {
                return true;
            }
        }
        return false;
    }
}
