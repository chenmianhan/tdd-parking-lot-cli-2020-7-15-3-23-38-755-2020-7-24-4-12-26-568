package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {

    private final List<ParkingLot> parkingLots;
    private final MessageRecord errorMessageRecord;
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        errorMessageRecord=new ErrorMessageRecord();
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkLot : parkingLots) {
            if (!parkLot.isFull()) {
                ticket = parkLot.park(car);
                break;
            }

        }
        return ticket;
    }

    public Car fetch(Ticket carTicket) {
        Car fethedCar=null;
        for (ParkingLot parkingLot : parkingLots) {
            fethedCar=parkingLot.fetch(carTicket);
            if(fethedCar!=null)break;
        }
        return fethedCar;
    }

    public String getErrorMessage() {
        return errorMessageRecord.getMessage();
    }
}