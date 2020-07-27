package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(Parkable... parkables) {
        super(parkables);
    }
    protected Ticket parkingStrategy(Car car) {
        int emptyPosition=Integer.MIN_VALUE;
        ParkingLot moreEmptyPositionParkingLot = (ParkingLot) parkables.get(0);
        for (Parkable parkable : parkables) {
            ParkingLot parkingLot = (ParkingLot) parkable;
            if (parkingLot.getEmptyPosition() > emptyPosition) {
                moreEmptyPositionParkingLot = parkingLot;
                emptyPosition = parkingLot.getEmptyPosition();
            }
        }
        Ticket ticket=moreEmptyPositionParkingLot.park(car);
        ticketParkingLotMap.put(ticket,moreEmptyPositionParkingLot);
        return ticket;
    }
}
