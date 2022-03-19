package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.ticket.TicketFullDto;
import com.sda.travelAgency.dto.tour.TourCreateDto;
import com.sda.travelAgency.dto.tour.TourFullDto;
import com.sda.travelAgency.model.Tour;

public class TourMapper {

    public static Tour tourToEntity(TourCreateDto tourCreateDto){
        Tour tour = new Tour();
        tour.setTourId(tourCreateDto.getTourId());

        return tour;
    }

    public static TourFullDto tourFullDto(Tour tour){
        TourFullDto tourFullDto = new TourFullDto();
        tourFullDto.setTourId(tour.getTourId());
        tourFullDto.setDepartureDate(tour.getDepartureDate());
        tourFullDto.setDateOfReturn(tour.getDateOfReturn());
        tourFullDto.setStartingCity(tour.getStartingCity());
        tourFullDto.setStartingAirport(tour.getStartingAirport());
        tourFullDto.setDestinationCity(tour.getDestinationCity());
        tourFullDto.setDestinationHotel(tour.getDestinationHotel());
        tourFullDto.setDestinationAirport(tour.getDestinationAirport());
        tourFullDto.setNumberOfDays(tour.getNumberOfDays());
        tourFullDto.setPrice(tourFullDto.getPrice());
        tourFullDto.setPriceChild(tour.getPriceChild());
        tourFullDto.setNumberOfSeats(tour.getNumberOfSeats());

        return tourFullDto;
    }
}
