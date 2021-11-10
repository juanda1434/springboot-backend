package com.mintic.misiontic.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mintic.misiontic.entity.Client;
import com.mintic.misiontic.entity.Reservation;
import com.mintic.misiontic.model.ClientCount;
import com.mintic.misiontic.repository.crud.IReservationCrudRepository;
public class ReservationRepository {
	
	@Autowired
	private IReservationCrudRepository repository;
	
	public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    public Optional<Reservation> get(int id){
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    public void delete(Reservation reservation){
    	repository.delete(reservation);
    }
    
    public List<Reservation> ReservacionStatusRepositorio (String status){
        return repository.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return repository.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    public List<ClientCount> getRepositoryClient(){
        List<ClientCount> res = new ArrayList<>();
        List<Object[]> report = repository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
        	Long uno=(Long)report.get(i)[1];
        	Client dos= (Client) report.get(i)[0];
            res.add(new ClientCount(uno,dos));
        }
        return res;
    }
	
}
