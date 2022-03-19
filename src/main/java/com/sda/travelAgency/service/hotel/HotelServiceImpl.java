package com.sda.travelAgency.service.hotel;

import com.sda.travelAgency.dto.hotel.HotelCreateDto;
import com.sda.travelAgency.dto.hotel.HotelFullDto;
import com.sda.travelAgency.mapper.HotelMapper;
import com.sda.travelAgency.model.Hotel;
import com.sda.travelAgency.repository.HotelRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public HotelFullDto create(HotelCreateDto hotelCreateDto) {
        Hotel hotel = HotelMapper.hotelToEntity(hotelCreateDto);
        Hotel savedHotel = hotelRepository.save(hotel);

        return HotelMapper.hotelToFullDto(savedHotel);
    }

    @Override
    public void saveAllHotels(List<Hotel> listOfHotels) {
        hotelRepository.saveAll(listOfHotels);
        System.out.println("All Hotels are created");
    }

    @Override
    public List<HotelFullDto> findAllHotels(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        List<HotelFullDto> returnList = new ArrayList<>();
        hotelRepository.findAll(pageable).forEach(entity -> {
            returnList.add(HotelMapper.hotelToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<HotelFullDto> findAllHotels() {
        List<HotelFullDto> returnList = new ArrayList<>();
        hotelRepository.findAll().forEach(entity -> {
            returnList.add(HotelMapper.hotelToFullDto(entity));
        });

        return returnList;
    }
}