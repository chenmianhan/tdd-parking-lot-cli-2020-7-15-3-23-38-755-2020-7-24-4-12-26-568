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

    public Ticket parking(MultiplyParkingLotParkingBoy parkingBoy, Car car) {
        return null;
    }
}
