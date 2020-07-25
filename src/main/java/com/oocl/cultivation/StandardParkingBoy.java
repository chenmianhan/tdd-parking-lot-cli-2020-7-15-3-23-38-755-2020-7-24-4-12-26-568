package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {

    private final List<ParkingLot> parkingLots;
    private final MessageRecord errorMessageRecord;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        errorMessageRecord = new ErrorMessageRecord();
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
        Car fetchedCar = null;

            if (carTicket==null) {
                errorMessageRecord.setMessage("Please provide your parking ticket.");
                return null;
            }


        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isTicketRight(carTicket)) {
                errorMessageRecord.setMessage("Unrecognized parking ticket.");
                return null;
            }
        }
        for (ParkingLot parkingLot : parkingLots) {
            fetchedCar = parkingLot.fetch(carTicket);
            if (fetchedCar != null) break;
        }
        return fetchedCar;
    }

    public String getErrorMessage() {
        return errorMessageRecord.getMessage();
    }
}