package com.sda.travelAgency.service.room;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.dto.room.RoomCreateDto;
import com.sda.travelAgency.dto.room.RoomFullDto;
import com.sda.travelAgency.exception.CustomException;
import com.sda.travelAgency.mapper.ReservationMapper;
import com.sda.travelAgency.mapper.RoomMapper;
import com.sda.travelAgency.model.Reservation;
import com.sda.travelAgency.model.Room;
import com.sda.travelAgency.repository.RoomRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomFullDto create(RoomCreateDto roomCreateDto) {
        Room room = RoomMapper.roomToEntity(roomCreateDto);
        Room savedRoom = roomRepository.save(room);

        return RoomMapper.roomToFullDto(savedRoom);
    }

    @Override
    public RoomFullDto findRoomById(Integer number) {
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
        Pageable pageable = PageRequest.of(number, capacity, Sort.by(sortBy));
        List<RoomFullDto> returnList = new ArrayList<>();
        roomRepository.findAll(pageable).forEach(entity -> {
            returnList.add(RoomMapper.roomToFullDto(entity));
        });
        return returnList;
    }

    @Override
    public List<RoomFullDto> findAllRooms() {
        List<RoomFullDto> returnList = new ArrayList<>();
        roomRepository.findAll().forEach(entity -> {
            returnList.add(RoomMapper.roomToFullDto(entity));
        });

        return returnList;
    }
}
