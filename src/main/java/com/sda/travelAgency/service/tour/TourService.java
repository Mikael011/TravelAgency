package com.sda.travelAgency.service.tour;

import com.sda.travelAgency.dto.tour.TourCreateDto;
import com.sda.travelAgency.dto.tour.TourFullDto;
import com.sda.travelAgency.model.Tour;
import java.util.List;

public interface TourService {

    TourFullDto create(TourCreateDto tourCreateDto);

    TourFullDto findTourById(Integer id);

    void saveAllTours(List<Tour>listOfTours);

    List<TourFullDto> findAllTours(Integer pageNumber, Integer pageSize, String sortBy);

    List<TourFullDto> findAllTours();

}
