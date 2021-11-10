package com.mintic.misiontic.repository.crud;
import org.springframework.data.repository.CrudRepository;

import com.mintic.misiontic.entity.Category;

public interface ICategoryCrudRepository extends CrudRepository<Category, Integer> {

}
