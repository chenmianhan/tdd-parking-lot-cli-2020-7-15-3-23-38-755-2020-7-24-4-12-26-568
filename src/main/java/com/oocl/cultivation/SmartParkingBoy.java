package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends MultiplyParkingLotParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    protected Ticket parkingStrategy(Car car) {
        int emptyPosition=Integer.MIN_VALUE;
        ParkingLot moreEmptyPositionParkingLot=parkingLots.get(0);
        for (ParkingLot parkLot : parkingLots) {
            if (parkLot.getEmptyPosition()>emptyPosition) {
                moreEmptyPositionParkingLot=parkLot;
            }
        }
        Ticket ticket=moreEmptyPositionParkingLot.park(car);
        ticketParkingLotMap.put(ticket,moreEmptyPositionParkingLot);
        return ticket;
    }
}
