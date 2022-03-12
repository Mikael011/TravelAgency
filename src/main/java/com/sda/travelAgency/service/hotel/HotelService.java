package com.sda.travelAgency.service.hotel;


import com.sda.travelAgency.dto.hotel.HotelFullDto;
import com.sda.travelAgency.model.Hotel;

import java.util.List;

public interface HotelService {

//    HotelFullDto findHotelById(Integer id);

    void saveAllHotels(List<Hotel> listOfHotels);

    List<HotelFullDto> findAllHotels(Integer pageNumber, Integer pageSize, String sortBy);

    List<HotelFullDto> findAllHotels();

}
