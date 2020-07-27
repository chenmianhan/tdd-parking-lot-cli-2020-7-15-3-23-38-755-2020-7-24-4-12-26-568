package com.oocl.cultivation;

public interface Parkable {
    Ticket park(Car car) throws ParkingException;

    boolean isNotFull();

    Car fetch(Ticket ticket) throws FetchException;
}
