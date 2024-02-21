package KodlamaioExercise.dataAccess;

import KodlamaioExercise.entities.Category;
import KodlamaioExercise.entities.Course;
import KodlamaioExercise.entities.Instructor;

public class JdbcDao implements CourseDao , CategoryDao,InstructorDao{
    @Override
    public void add(Course course) {

        System.out.println("Jdbc ile Kurs Eklendi!");
    }
    @Override
    public void add(Category category) {

        System.out.println("Jdbc ile Kategori Eklendi!");
    }
    @Override
    public void addInstructor(Instructor instructor){
        System.out.println("Jdbc ile Eğitmen Eklendi!");
    }
    public void getAllInstructor(Instructor instructor){
        System.out.println("Tüm eğitmenler Jdbc ile getirildi!");
    }


}
