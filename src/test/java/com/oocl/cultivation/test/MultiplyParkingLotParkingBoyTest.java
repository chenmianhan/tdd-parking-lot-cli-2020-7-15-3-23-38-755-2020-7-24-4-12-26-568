package com.oocl.cultivation.test;


import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MultiplyParkingLotParkingBoyTest {
    @Test
    void should_fetch_null_car_when_fetch_given_no_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        MultiplyParkingLotParkingBoy multiplyParkingLotParkingBoy = new MultiplyParkingLotParkingBoy(parkingLots);

        //when
        Car car = multiplyParkingLotParkingBoy.fetch(null);

        //then
        assertNull(car);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_then_no_provide_the_ticket_and_query_message() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        MultiplyParkingLotParkingBoy multiplyParkingLotParkingBoy = new MultiplyParkingLotParkingBoy(parkingLots);

        //when
        multiplyParkingLotParkingBoy.fetch(null);

        //then
        assertEquals("Please provide your parking ticket.", multiplyParkingLotParkingBoy.getErrorMessage());
    }
}
