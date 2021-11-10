package com.mintic.misiontic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.misiontic.entity.Category;
import com.mintic.misiontic.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository methodsCrud;

    public List<Category> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Category> getCategory(int CategoryId) {
        return methodsCrud.get(CategoryId);
    }

    public Category save(Category Category){
        if(Category.getId()==null){
            return methodsCrud.save(Category);
        }else{
            Optional<Category> e= methodsCrud.get(Category.getId());
            if(e.isEmpty()){
                return methodsCrud.save(Category);
            }else{
                return Category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= methodsCrud.get(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return methodsCrud.save(g.get());
            }
        }
        return category;
    }


    public boolean deleteCategory(int CategoryId) {
        Boolean aBoolean = getCategory(CategoryId).map(Category -> {
            methodsCrud.delete(Category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
