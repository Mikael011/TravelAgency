package com.sda.travelAgency.controller.room;

import com.sda.travelAgency.dto.reservation.ReservationCreateDto;
import com.sda.travelAgency.dto.reservation.ReservationFullDto;
import com.sda.travelAgency.dto.room.RoomCreateDto;
import com.sda.travelAgency.dto.room.RoomFullDto;
import com.sda.travelAgency.service.room.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/room")
@ControllerAdvice
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomFullDto> create(@RequestParam RoomCreateDto roomCreateDto) {
        RoomFullDto roomFullDto = roomService.create((roomCreateDto));

        return ResponseEntity.ok(roomFullDto);
    }

    @GetMapping("/findRoomById")
    public ResponseEntity<RoomFullDto> findRoomById(@RequestParam Integer roomId) {
        RoomFullDto roomFullDto = roomService.findRoomById(roomId);

        return ResponseEntity.ok(roomFullDto);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RoomFullDto>> findAllRooms(@RequestParam(defaultValue = "0") Integer number,
                                                          @RequestParam(defaultValue = "5") Integer capacity,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        List<RoomFullDto> listOfRoom = roomService.findAllRooms(number, capacity, sortBy);

        return ResponseEntity.ok(listOfRoom);
    }
}
