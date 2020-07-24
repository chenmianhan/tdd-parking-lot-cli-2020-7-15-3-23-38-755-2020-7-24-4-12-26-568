package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket carTicket) {
        if(parkingLot.isTicketNull(carTicket)||!parkingLot.isTicketRight(carTicket))
            return null;
        else return parkingLot.fetch(carTicket);
    }

}
