package mum.ea.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Building;
import mum.ea.domain.Room;
import mum.ea.repository.BuildingRepository;
import mum.ea.repository.RoomRepository;

@Service
@Transactional
public class RoomService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private BuildingRepository buildingRepository;

	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		roomRepository.findAll().forEach(rooms::add);
		return rooms;
	}

	public Room getRoom(int roomId) {
		return roomRepository.findOne(roomId);
	}

	public void addRoom(Room room) {
		roomRepository.save(room);
	}

	public void updateRoom(Room room) {
		roomRepository.save(room);
	}

	public void deleteRoom(Room room) {
		roomRepository.delete(room);
	}

	public void deleteRoom(int roomId) {
		roomRepository.delete(roomId);
	}

	public List<Room> findByBuilding(int buildingId) {
		return roomRepository.findByBuilding(buildingRepository.findOne(buildingId));
	}
}
