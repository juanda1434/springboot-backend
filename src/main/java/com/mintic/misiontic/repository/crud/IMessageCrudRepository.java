package com.mintic.misiontic.repository.crud;
import org.springframework.data.repository.CrudRepository;

import com.mintic.misiontic.entity.Message;

public interface IMessageCrudRepository extends CrudRepository<Message, Integer> {

}
