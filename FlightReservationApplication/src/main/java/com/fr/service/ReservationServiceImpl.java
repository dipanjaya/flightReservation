package com.fr.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fr.dto.ReservationDetails;
import com.fr.entity.Flight;
import com.fr.entity.Passenger;
import com.fr.entity.Reservation;
import com.fr.repos.FlightRepository;
import com.fr.repos.PassengerRepository;
import com.fr.repos.ReservationRepository;
import com.fr.util.EmailUtil;
import com.fr.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${itinerary.dirpath}")
	private String ITINERARY_DIR = "F:\\Spring Workspace\\Boot\\reservationPDF";

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private PDFGenerator generator;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Override
	public Reservation bookFlight(ReservationDetails details) {

		LOGGER.info("Inside bookFlight() ");
		// Make payment by using third party api and after successful amount paid

		Long flightId = details.getFlightId();
		LOGGER.info("Fetching flight for flight id :: "+flightId);
		Flight flight = flightRepository.getOne(flightId);

		Passenger passenger = new Passenger();
		passenger.setFirstName(details.getPassengerFirstName());
		passenger.setLastName(details.getPassengerLastName());
		passenger.setEmail(details.getPassengerEmail());
		passenger.setPhone(details.getPassengerPhone());
		LOGGER.info("Saving Passenger :: "+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation :: "+reservation);
		
		Reservation savedReservation = reservationRepository.save(reservation);

		new Thread() {
			@Override
			public void run() {
				String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
				LOGGER.info("Genearating itinerary for id :: "+savedReservation.getId());
				generator.generateItinerary(savedReservation, filePath);
				LOGGER.info("Emailing the itinerary ");
				emailUtil.sendItinerary(passenger.getEmail(), filePath);

			}
		}.start();

		return savedReservation;
	}

}
