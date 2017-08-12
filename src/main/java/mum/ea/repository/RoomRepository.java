package mum.ea.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
	public List<Room> findRoomByBuilding(int buildingId);
}
