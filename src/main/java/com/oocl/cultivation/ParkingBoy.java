package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private final MessageRecord errorMessageRecord;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        errorMessageRecord = new ErrorMessageRecord();
    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket carTicket) {
        if (parkingLot.isTicketNull(carTicket)) {
            errorMessageRecord.setMessage("Please provide your parking ticket.");
            return null;
        }
        if (!parkingLot.isTicketRight(carTicket)) {
            errorMessageRecord.setMessage("Unrecognized parking ticket.");
            return null;

        } else return parkingLot.fetch(carTicket);
    }

    public String getErrorMessage() {
        return errorMessageRecord.getMessage();
    }

}
