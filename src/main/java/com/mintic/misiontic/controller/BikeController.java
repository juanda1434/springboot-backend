package com.mintic.misiontic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mintic.misiontic.entity.Bike;
import com.mintic.misiontic.service.BikeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BikeController{


    @Autowired
    private BikeService service;
    @GetMapping("/all")
    public List<Bike> getBikes(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int bikeId) {
        return service.getBike(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return service.save(bike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return service.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId) {
        return service.deleteBike(bikeId);
    }

	
	
	
}
