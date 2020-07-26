package com.oocl.cultivation;

import java.util.List;

public class MultiplyParkingLotParkingBoy {
    private final MessageRecord errorMessageRecord;
    protected final List<ParkingLot> parkingLots;
    public MultiplyParkingLotParkingBoy(List<ParkingLot> parkingLots) {
        errorMessageRecord=new ErrorMessageRecord();
        this.parkingLots=parkingLots;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            errorMessageRecord.setMessage("Please provide your parking ticket.");
        }
        if(!isTicketRight(ticket)){
            errorMessageRecord.setMessage("Unrecognized parking ticket.");
        }
        return null;

    }

    public String getErrorMessage() {
        return errorMessageRecord.getMessage();
    }

    public Ticket park(Car car) {
        if (isAllFull()) {
            errorMessageRecord.setMessage("Not enough position.");
            return null;
        }
        return parkingStrategy(car);
    }

    protected Ticket parkingStrategy(Car car) {
        return null;
    }

    private boolean isAllFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull())return false;
        }
        return true;
    }

    private boolean isTicketRight(Ticket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isTicketRight(carTicket)) {
                return true;
            }
        }
        return false;
    }
}