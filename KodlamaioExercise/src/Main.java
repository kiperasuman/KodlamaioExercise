import KodlamaioExercise.business.CategoryManager;
import KodlamaioExercise.business.CourseManager;
import KodlamaioExercise.business.InstructorManager;
import KodlamaioExercise.core.logging.DatabaseLogger;
import KodlamaioExercise.core.logging.FileLogger;
import KodlamaioExercise.core.logging.Logger;
import KodlamaioExercise.dataAccess.HibernateDao;
import KodlamaioExercise.dataAccess.JdbcDao;
import KodlamaioExercise.entities.Category;
import KodlamaioExercise.entities.Course;
import KodlamaioExercise.entities.Instructor;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");

        Instructor instructor = new Instructor();
        instructor.setId(1);
        instructor.setName("Engin Demiroğ");

        Instructor instructor2 = new Instructor();
        instructor2.setId(2);
        instructor2.setName("Halil Enes Kalaycı");

        Instructor[] allInstructor = {instructor, instructor2};
        Logger[] loggers = {new DatabaseLogger(), new FileLogger()};


        InstructorManager instructorManager = new InstructorManager(new JdbcDao(), List.of(loggers));

        for (Instructor variable : allInstructor) {
            instructorManager.addInstructor(variable);
            instructorManager.getAllInstructor(variable);
        }

        Course course = new Course();
        course.setId(1);
        course.setUnitPrice(200.00);
        course.setName("Yazılım Geliştirici Yetiştirme Kampı - JAVA ");

        Course course2 = new Course();
        course2.setId(2);
        course2.setUnitPrice(199.99);
        course2.setName("Yazılım Geliştirici Yetiştirme Kampı - Python & Selenium");

        CourseManager manager = new CourseManager(new HibernateDao(), List.of(loggers));
        manager.add(course);
        manager.add(course2);

        Category category = new Category();
        category.setId(1);
        category.setName("Programlama");
        CategoryManager categoryManager = new CategoryManager(new JdbcDao(), List.of(loggers));
        categoryManager.add(category);


    }
}