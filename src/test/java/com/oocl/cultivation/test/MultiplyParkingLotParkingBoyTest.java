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

    @Test
    void should_return_not_enough_position_when_park_car_then_parking_lot_full_and_query_message() {
        //given
        int capacity = 10;
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        for (int i = 0; i < capacity; i++) {
            parkingLot1.park(new Car());
            parkingLot2.park(new Car());
        }
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        MultiplyParkingLotParkingBoy multiplyParkingLotParkingBoy = new MultiplyParkingLotParkingBoy(parkingLots);

        //when
        multiplyParkingLotParkingBoy.park(new Car());

        //then
        assertEquals("Not enough position.", multiplyParkingLotParkingBoy.getErrorMessage());
    }
}
