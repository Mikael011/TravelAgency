package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.room.RoomCreateDto;
import com.sda.travelAgency.dto.room.RoomFullDto;
import com.sda.travelAgency.model.Room;

public class RoomMapper {

    public static Room roomToEntity(RoomCreateDto roomCreateDto) {
        Room room = new Room();
        room.setNumber(roomCreateDto.getNumber());
        room.setCapacity(roomCreateDto.getCapacity());
        room.setDescription(roomCreateDto.getDescription());

        return room;
    }

    public static RoomFullDto roomToFullDto(Room room) {
        RoomFullDto roomFullDto = new RoomFullDto();
        roomFullDto.setNumber(room.getNumber());
        roomFullDto.setCapacity(room.getCapacity());
        roomFullDto.setDescription(room.getDescription());

        return roomFullDto;
    }
}
