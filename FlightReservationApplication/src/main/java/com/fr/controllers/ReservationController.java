package com.fr.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.dto.ReservationDetails;
import com.fr.entity.Flight;
import com.fr.entity.Reservation;
import com.fr.repos.FlightRepository;
import com.fr.service.ReservationService;

@Controller
@RequestMapping
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightRepository repo;
	
	@Autowired
	private ReservationService service;
	
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservationPage(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		LOGGER.info("showCompleteReservationPage() invoked with FlightId :: "+flightId);
		Flight flight = repo.getOne(flightId);
		modelMap.addAttribute("flight",flight);
		LOGGER.info("Flight is :: "+flight);
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(@ModelAttribute("reservationDetails") ReservationDetails reservationDetails, ModelMap modelMap) {
		LOGGER.info("completeReservation() -- ReservationDetails ::"+reservationDetails);
		Reservation reservation = service.bookFlight(reservationDetails);
		modelMap.addAttribute("msg","Reservation created Successfully and the flightid is :: "+reservation.getId());
		return "reservationConfirmation";
	} 
	
}
