package com.fr.service;

import com.fr.dto.ReservationDetails;
import com.fr.entity.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationDetails reservationDetails);
}
