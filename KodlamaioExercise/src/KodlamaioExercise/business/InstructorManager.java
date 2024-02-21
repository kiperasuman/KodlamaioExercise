package KodlamaioExercise.business;

import KodlamaioExercise.core.logging.Logger;
import KodlamaioExercise.dataAccess.InstructorDao;
import KodlamaioExercise.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager{

    private InstructorDao instructorDao;
    private List<Instructor> allInstructors = new ArrayList<>();
    private List<Logger> loggers;
    public InstructorManager(InstructorDao instructorDao,List<Logger> loggers){
        this.instructorDao = instructorDao;
        this.loggers  =loggers;
    }
    public void addInstructor(Instructor instructor){
        instructorDao.addInstructor(instructor);
        allInstructors.add(instructor);
        System.out.println(instructor.getName());

        for (Logger allLoggers:loggers) {
            allLoggers.log(instructor.getName());
        }
    }
    public void getAllInstructor(Instructor instructor){
       instructorDao.getAllInstructor(instructor);
    }


}
