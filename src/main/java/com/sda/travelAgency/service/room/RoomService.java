package com.sda.travelAgency.service.room;

import com.sda.travelAgency.dto.room.RoomFullDto;
import com.sda.travelAgency.model.Room;

import java.util.List;

public interface RoomService {

    RoomFullDto findByRoomById(Integer id);

    void saveAllRooms(List<Room> lisOfRooms);

    List<RoomFullDto> findAllRooms(Integer number, Integer capacity, String sortBy);

    List<RoomFullDto> findAllRooms();
}
