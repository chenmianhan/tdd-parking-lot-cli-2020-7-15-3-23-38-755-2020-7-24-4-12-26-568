package com.oocl.cultivation;

public interface Parkable {
    Ticket park(Car car) throws ParkingException;

}
