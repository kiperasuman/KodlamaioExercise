package KodlamaioExercise.dataAccess;

import KodlamaioExercise.entities.Instructor;

public interface InstructorDao {
    void getAllInstructor(Instructor instructor);
    void addInstructor(Instructor instructor);
}
