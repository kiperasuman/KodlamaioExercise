package KodlamaioExercise.dataAccess;

import KodlamaioExercise.entities.Category;
import KodlamaioExercise.entities.Course;
import KodlamaioExercise.entities.Instructor;

public  class HibernateDao implements CourseDao , CategoryDao,InstructorDao{

    @Override
    public void add(Course course) {
        System.out.println("Hibernate ile kurs eklendi");
    }

    @Override
    public void add(Category category) {
        System.out.println("Hibernate ile kategori eklendi");
    }

    @Override
    public  void getAllInstructor(Instructor instructor) {
        System.out.println("Tüm eğitmenler Hibernate ile getirildi!");
    }

    @Override
    public void addInstructor(Instructor instructor) {
        System.out.println("Eğitmen Hibernate ile Eklendi!");

    }
}
