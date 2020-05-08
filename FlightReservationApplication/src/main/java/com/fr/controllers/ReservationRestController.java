package com.fr.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.dto.ReservationUpdateDetails;
import com.fr.entity.Reservation;
import com.fr.repos.ReservationRepository;

@RestController
@RequestMapping
@CrossOrigin
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("findReservation() invoked for Id" + id);
		return reservationRepository.getOne(id);
	}

	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateDetails details) {
		LOGGER.info("ReservationUpdateDetails :: " + details);
		Reservation reservation = reservationRepository.getOne(details.getId());
		reservation.setCheckedIn(details.isCheckedIn());
		reservation.setNumberOfBags(details.getNumberOfBags());
		Reservation updatedReservation = reservationRepository.save(reservation);
		return reservationRepository.save(updatedReservation);
	}

}
