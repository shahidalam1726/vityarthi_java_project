package hostel.service;

import hostel.model.Room;
import hostel.model.Student;
import java.util.ArrayList;
import java.util.List;

public class AllocationEngine {
    private List<Room> rooms;

    public AllocationEngine(List<Room> rooms) {
        this.rooms = rooms;
    }

    public synchronized Room allocateRoom(Student student) throws Exception {
        for (Room room : rooms) {
            if (!room.isAllocated() && room.getRoomType().equalsIgnoreCase(student.getPreferredRoomType())) {
                room.allocateTo(student.getStudentId());
                return room;
            }
        }
        
        // Fallback: Assign any available room if preferred type is full
        for (Room room : rooms) {
            if (!room.isAllocated()) {
                room.allocateTo(student.getStudentId());
                return room;
            }
        }
        throw new Exception("No rooms available in the system!");
    }

    public List<Room> getAllRooms() { return rooms; }
}