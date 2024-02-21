package KodlamaioExercise.business;

import KodlamaioExercise.core.logging.Logger;
import KodlamaioExercise.dataAccess.CategoryDao;
import KodlamaioExercise.entities.Category;
import KodlamaioExercise.entities.Course;

import java.util.ArrayList;
import java.util.List;

public  class CategoryManager   {
    private CategoryDao categoryDao;
    private List<Category> allCategories = new ArrayList<>();
    private List<Logger> loggers;
    public CategoryManager(CategoryDao categoryDao,List<Logger> loggers){
        this.categoryDao = categoryDao;
        this.loggers = loggers;

    }
    public void add(Category category ) throws Exception{
        if(isCategoryAlreadyAdded(category)) throw new Exception("Kategori ismi tekrar edemez!");
        else {
            allCategories.add(category);
            categoryDao.add(category);
        }
        System.out.println("Kategori eklendi : " + category.getName());
        for (Logger allLogger:loggers) {
            allLogger.log(category.getName());
        }
    }

    private boolean isCategoryAlreadyAdded(Category category) {
        for (Category existingCategory : allCategories) {
            if (existingCategory.equals(category)) {
                return true;
            }
        }
        return false;
    }

}
