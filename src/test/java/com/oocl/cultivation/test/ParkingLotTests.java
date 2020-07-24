package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTests {
    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car();
        //when
        Ticket carTicket=parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }
}
