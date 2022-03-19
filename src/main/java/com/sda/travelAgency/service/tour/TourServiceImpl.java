package com.sda.travelAgency.service.tour;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.dto.tour.TourCreateDto;
import com.sda.travelAgency.dto.tour.TourFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.ReservationMapper;
import com.sda.travelAgency.mapper.TourMapper;
import com.sda.travelAgency.model.Reservation;
import com.sda.travelAgency.model.Tour;
import com.sda.travelAgency.repository.TourRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService{

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public TourFullDto create(TourCreateDto tourCreateDto) {
        Tour tour = TourMapper.tourToEntity(tourCreateDto);
        Tour savedTour = tourRepository.save(tour);

        return TourMapper.tourFullDto(savedTour);
    }

    @Override
    public TourFullDto findTourById(Integer id) {
       Tour tour  = tourRepository.findById(id).orElseThrow(() ->
                new CustomException("Tour with id " + id + " not found!"));

        return TourMapper.tourFullDto(tour);
    }

    @Override
    public void saveAllTours(List<Tour> listOfTours) {
        tourRepository.saveAll(listOfTours);
        System.out.println("All tours are created");
    }

    @Override
    public List<TourFullDto> findAllTours(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<TourFullDto> returnList = new ArrayList<>();
        tourRepository.findAll(pageable).forEach(entity -> {
            returnList.add(TourMapper.tourFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<TourFullDto> findAllTours() {
        List<TourFullDto> returnList = new ArrayList<>();
        tourRepository.findAll().forEach(entity -> {
            returnList.add(TourMapper.tourFullDto(entity));
        });
        return returnList;
    }
}
