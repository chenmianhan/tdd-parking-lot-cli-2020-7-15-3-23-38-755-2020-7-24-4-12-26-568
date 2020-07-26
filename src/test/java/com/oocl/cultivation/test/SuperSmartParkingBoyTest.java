package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperSmartParkingBoyTest {
    @Test
    void should_park_at_larger_available_position_rate_parking_lot_when_parking_a_car_given_two_different_position_rate_parking_lot() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingLot higherPositionRateParkingLot = new ParkingLot(20);
        ParkingLot lowerPositionRateParkingLot = new ParkingLot(10);
        int carNumber = 5;
        for (int carIndex = 0; carIndex < carNumber; carIndex++) {
            higherPositionRateParkingLot.park(new Car());
            lowerPositionRateParkingLot.park(new Car());
        }
        parkingLots.add(lowerPositionRateParkingLot);
        parkingLots.add(higherPositionRateParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        superSmartParkingBoy.park(new Car());
        //then
        assertEquals(carNumber, lowerPositionRateParkingLot.getCurStock());
        assertEquals(carNumber + 1, higherPositionRateParkingLot.getCurStock());
    }
}

