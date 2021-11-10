package com.mintic.misiontic.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mintic.misiontic.entity.Category;
import com.mintic.misiontic.repository.crud.ICategoryCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public class CategoryRepository {
	
	@Autowired
	private ICategoryCrudRepository repository;
	
	public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    public Optional<Category> get(int id){
        return repository.findById(id);
    }

    public Category save(Category Category){
        return repository.save(Category);
    }
    public void delete(Category Category){
    	repository.delete(Category);
    }
	
}
