package com.fr.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.entity.Flight;
import com.fr.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
