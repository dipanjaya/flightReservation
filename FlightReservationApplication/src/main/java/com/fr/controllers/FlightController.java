package com.fr.controllers;

import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fr.entity.Flight;
import com.fr.repos.FlightRepository;

@Controller
@RequestMapping
public class FlightController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {
		LOGGER.info("findFlights() From :: " + from + "To ::" + to + "Departure Date :: " + departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flights  finds are :: " + flights);
		return "displayFlights";
	}

	@GetMapping("/admin/showAddFlight")
	public String showAddFlights() {
		return "addFlight";
	}

}
