package com.oocl.cultivation;


import java.util.LinkedList;
import java.util.List;

public class Manager {
    private List<MultiplyParkingLotParkingBoy> multiplyParkingLotParkingBoys = new LinkedList<>();
    public void addParkingBoy(MultiplyParkingLotParkingBoy parkingBoy) {
        multiplyParkingLotParkingBoys.add(parkingBoy);
    }

    public List<MultiplyParkingLotParkingBoy> getParkingBotList() {
        return multiplyParkingLotParkingBoys;
    }

    public Ticket park(MultiplyParkingLotParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public Car fetch(MultiplyParkingLotParkingBoy parkingBoy, Ticket ticket) {
        return parkingBoy.fetch(ticket);
    }
}
