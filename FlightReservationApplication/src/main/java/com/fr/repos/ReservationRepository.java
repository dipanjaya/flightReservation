package com.fr.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.fr.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
