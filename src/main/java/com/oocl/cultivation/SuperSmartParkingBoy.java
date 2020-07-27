package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(Parkable... parkables) {
        super(parkables);
    }

    @Override
    protected Ticket parkingStrategy(Car car) {
        double higherAvailablePositionRate = 0;
        ParkingLot higherAvailablePositionRateParkingLot = (ParkingLot) parkables.get(0);
        for (Parkable parkable : parkables) {
            ParkingLot parkingLot = (ParkingLot) parkable;
            if (parkingLot.getAvailablePositionRate() > higherAvailablePositionRate) {
                higherAvailablePositionRateParkingLot = parkingLot;
                higherAvailablePositionRate = parkingLot.getAvailablePositionRate();
            }
        }

        Ticket ticket = higherAvailablePositionRateParkingLot.park(car);
        ticketParkingLotMap.put(ticket, higherAvailablePositionRateParkingLot);
        return ticket;
    }
}
