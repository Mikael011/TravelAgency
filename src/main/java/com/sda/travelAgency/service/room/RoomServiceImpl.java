package com.sda.travelAgency.service.room;

import antlr.collections.impl.LList;
import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.dto.room.RoomFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.CityMapper;
import com.sda.travelAgency.mapper.RoomMapper;
import com.sda.travelAgency.model.Room;
import com.sda.travelAgency.repository.RoomRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomFullDto findByRoomById(Integer number) {
        Room room = roomRepository.findByNumber(number).orElseThrow(() -> new CustomException("Room with number " + number + " not found!"));

        return RoomMapper.roomToFullDto(room);
    }

    @Override
    public void saveAllRooms(List<Room> lisOfRooms) {
        roomRepository.saveAll(lisOfRooms);
        System.out.println("All rooms are saved.");
    }

    @Override
    public List<RoomFullDto> findAllRooms(Integer number, Integer capacity, String sortBy) {
//        Pageable pageable = PageRequest.of(number, capacity, Sort.by(sortBy));
        return null;
    }

    @Override
    public List<RoomFullDto> findAllRooms() {
        List<RoomFullDto> returnList = new ArrayList<>();
        roomRepository.findAll().forEach(entity -> {
            returnList.add(CityMapper.cityFullDto(entity));
        });

        return returnList;
    }
}
