package com.mintic.misiontic.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mintic.misiontic.entity.Client;
import com.mintic.misiontic.repository.crud.IClienteCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public class ClienteRepository {
	
	@Autowired
	private IClienteCrudRepository repository;
	
	public List<Client> getAll(){
        return (List<Client>) repository.findAll();
    }
    public Optional<Client> get(int id){
        return repository.findById(id);
    }

    public Client save(Client client){
        return repository.save(client);
    }
    public void delete(Client client){
    	repository.delete(client);
    }
	
}
