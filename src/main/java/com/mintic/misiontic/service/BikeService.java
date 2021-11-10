package com.mintic.misiontic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.misiontic.entity.Bike;
import com.mintic.misiontic.repository.BikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository methodsCrud;

    public List<Bike> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Bike> getBike(int BikeId) {
        return methodsCrud.get(BikeId);
    }

    public Bike save(Bike Bike){
        if(Bike.getId()==null){
            return methodsCrud.save(Bike);
        }else{
            Optional<Bike> e= methodsCrud.get(Bike.getId());
            if(e.isEmpty()){
                return methodsCrud.save(Bike);
            }else{
                return Bike;
            }
        }
    }

    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> e= methodsCrud.get(bike.getId());
            if(!e.isEmpty()){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }


    public boolean deleteBike(int BikeId) {
        Boolean aBoolean = getBike(BikeId).map(Bike -> {
            methodsCrud.delete(Bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
