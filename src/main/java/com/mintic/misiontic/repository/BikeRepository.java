package com.mintic.misiontic.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mintic.misiontic.entity.Bike;
import com.mintic.misiontic.repository.crud.IBikeCrudRepository;
public class BikeRepository {
	
	@Autowired
	private IBikeCrudRepository repository;
	
	public List<Bike> getAll(){
        return (List<Bike>) repository.findAll();
    }
    public Optional<Bike> get(int id){
        return repository.findById(id);
    }

    public Bike save(Bike Bike){
        return repository.save(Bike);
    }
    public void delete(Bike Bike){
    	repository.delete(Bike);
    }
	
}
