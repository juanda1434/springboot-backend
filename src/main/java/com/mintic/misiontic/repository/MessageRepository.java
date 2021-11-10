package com.mintic.misiontic.repository;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mintic.misiontic.entity.Message;
import com.mintic.misiontic.repository.crud.IMessageCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public class MessageRepository {
	
	@Autowired
	private IMessageCrudRepository repository;
	
	public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    public Optional<Message> get(int id){
        return repository.findById(id);
    }

    public Message save(Message client){
        return repository.save(client);
    }
    public void delete(Message client){
    	repository.delete(client);
    }
	
}
