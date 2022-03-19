package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.hotel.HotelCreateDto;
import com.sda.travelAgency.dto.hotel.HotelFullDto;
import com.sda.travelAgency.model.Hotel;

public class HotelMapper {

    public static Hotel hotelToEntity(HotelCreateDto hotelCreateDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelCreateDto.getName());
        hotel.setNumberOfStars(hotelCreateDto.getNumberOfStars());
        hotel.setDescription(hotelCreateDto.getDescription());
        return hotel;
    }

    public static HotelFullDto hotelToFullDto(Hotel hotel) {
        HotelFullDto hotelFullDto = new HotelFullDto();
        hotelFullDto.setId(hotel.getId());
        hotelFullDto.setName(hotel.getName());
        hotelFullDto.setNumberOfStars(hotel.getNumberOfStars());
        hotelFullDto.setDescription(hotel.getDescription());
        return hotelFullDto;
    }
}
