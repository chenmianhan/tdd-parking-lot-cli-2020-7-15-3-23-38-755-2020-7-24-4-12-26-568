package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingException;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SmartParkingBoyTest {
    @Test
    void should_park_at_the_more_empty_parking_lot_when_parking_car_given_two_different_stock_parking_lot() throws ParkingException {
        //given
        int firstCarNumber = 5;
        int secondCarNumber = 2;

        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        for (int carIndex = 0; carIndex < firstCarNumber; carIndex++) {
            firstParkingLot.park(new Car());
        }
        for (int carIndex = 0; carIndex < secondCarNumber; carIndex++) {
            secondParkingLot.park(new Car());
        }

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot);

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(firstCarNumber, firstParkingLot.getCurStock());
        assertEquals(secondCarNumber + 1, secondParkingLot.getCurStock());
    }

}
