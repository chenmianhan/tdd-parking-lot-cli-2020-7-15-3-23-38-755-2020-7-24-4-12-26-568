package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMessageTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_then_not_provide_the_right_ticket_and_query_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        parkingBoy.park(new Car());
        parkingBoy.fetch(new Ticket());

        //then
        assertEquals("Unrecognized parking ticket.", parkingBoy.getErrorMessage());
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_then_provide_the_used_ticket_and_query_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Ticket usedTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(usedTicket);
        parkingBoy.fetch(usedTicket);

        //then
        assertEquals("Unrecognized parking ticket.", parkingBoy.getErrorMessage());
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_then_provide_the_used_ticket_and_query_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        Ticket usedTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(null);

        //then
        assertEquals("Please provide your parking ticket.", parkingBoy.getErrorMessage());
    }

}
