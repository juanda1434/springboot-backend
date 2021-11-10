package com.mintic.misiontic.repository.crud;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.mintic.misiontic.entity.Reservation;

public interface IReservationCrudRepository extends CrudRepository<Reservation, Integer> {

	public List<Reservation> findAllByStatus (String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
}
