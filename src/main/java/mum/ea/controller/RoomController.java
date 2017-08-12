package mum.ea.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.ea.domain.Room;
import mum.ea.service.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/rooms")
	public List<Room> getRooms() {
		return roomService.getAllRooms();
	}
	
	@RequestMapping("/rooms/{id}")
	public Room getRoom(@PathVariable int id) {
		return roomService.getRoom(id);
	}
	
	@RequestMapping("/buildings/{buildingId}/rooms")
	public  List<Room> getBuildingRooms(@PathVariable int buildingId) {
		return roomService.findByBuilding(buildingId);
	}
}
