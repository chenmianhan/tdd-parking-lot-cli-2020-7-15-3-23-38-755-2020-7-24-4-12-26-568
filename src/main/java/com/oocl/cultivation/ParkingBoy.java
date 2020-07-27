package com.oocl.cultivation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    protected final MessageRecord errorMessageRecord;
    protected final List<ParkingLot> parkingLots;
    protected final Map<Ticket, ParkingLot> ticketParkingLotMap;
    public ParkingBoy(List<ParkingLot> parkingLots) {
        errorMessageRecord=new ErrorMessageRecord();
        this.parkingLots=parkingLots;
        ticketParkingLotMap = new HashMap<>();
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            errorMessageRecord.setMessage("Please provide your park ticket.");
            return null;
        }
        if(!isTicketRight(ticket)){
            errorMessageRecord.setMessage("Unrecognized park ticket.");
            return null;
        }
        ParkingLot targetParkingLot = ticketParkingLotMap.remove(ticket);
        return targetParkingLot.fetch(ticket);
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
        for (ParkingLot parkLot : parkingLots) {
            if (!parkLot.isFull()) {
                Ticket ticket= parkLot.park(car);
                ticketParkingLotMap.put(ticket,parkLot);
                return ticket;
            }
        }
        return null;
    }

    private boolean isAllFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull())return false;
        }
        return true;
    }

    private boolean isTicketRight(Ticket carTicket) {
        return ticketParkingLotMap.containsKey(carTicket);
    }
}