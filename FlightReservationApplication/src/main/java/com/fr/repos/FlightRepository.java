package com.fr.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fr.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("select f from Flight f where f.departureCity=:departureCity and f.arrivalCity=:arrivalCity and f.dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,
			@Param("dateOfDeparture") Date departureDate);

}
