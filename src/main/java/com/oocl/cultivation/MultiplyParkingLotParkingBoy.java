package com.oocl.cultivation;

import java.util.List;

public class MultiplyParkingLotParkingBoy {
    private final MessageRecord errorMessageRecord;
    private final List<ParkingLot> parkingLots;
    public MultiplyParkingLotParkingBoy(List<ParkingLot> parkingLots) {
        errorMessageRecord=new ErrorMessageRecord();
        this.parkingLots=parkingLots;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            errorMessageRecord.setMessage("Please provide your parking ticket.");

        }
        return null;
    }

    public String getErrorMessage() {
        return errorMessageRecord.getMessage();
    }

    public void park(Car car) {
        if (isAllFull()) {
            errorMessageRecord.setMessage("Not enough position.");

        }
    }

    private boolean isAllFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull())return false;
        }
        return true;
    }
}
