package com.oocl.cultivation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.oocl.cultivation.ErrorMessage.*;

public class ParkingBoy implements Parkable {
    protected List<Parkable> parkables;
    protected final Map<Ticket, Parkable> ticketParkingLotMap;

    public ParkingBoy(Parkable... parkables) {
        this.parkables = Arrays.asList(parkables);
        ticketParkingLotMap = new HashMap<>();
    }

    @Override
    public Car fetch(Ticket ticket) throws FetchException {
        if(ticket==null){
            throw new FetchException(NOTTICKET.getError());
        }
        if(!isTicketRight(ticket)){
            throw new FetchException(WRONGTICKET.getError());
        }
        Parkable targetParkingLot = ticketParkingLotMap.remove(ticket);
        return targetParkingLot.fetch(ticket);
    }

    @Override
    public Ticket park(Car car) throws ParkingException {
        if (!isNotFull()) {
            throw new ParkingException(NOTSPACE.getError());
        }
        return parkingStrategy(car);
    }

    @Override
    public boolean isNotFull() {
        for (Parkable parkable : parkables) {
            if (parkable.isNotFull()) return true;
        }
        return false;
    }

    protected Ticket parkingStrategy(Car car) throws ParkingException {
        for (Parkable parkable : parkables) {
            if (parkable.isNotFull()) {
                Ticket ticket = parkable.park(car);
                ticketParkingLotMap.put(ticket, parkable);
                return ticket;
            }
        }
        return null;
    }


    private boolean isTicketRight(Ticket carTicket) {
        return ticketParkingLotMap.containsKey(carTicket);
    }
}