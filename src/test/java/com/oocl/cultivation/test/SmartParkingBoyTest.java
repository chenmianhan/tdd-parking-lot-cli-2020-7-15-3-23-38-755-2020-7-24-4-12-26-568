package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import com.oocl.cultivation.StandardParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SmartParkingBoyTest {
    @Test
    void should_park_at_the_more_empty_parking_lot_when_parking_car_given_two_different_stock_parking_lot() {
        //given
        int firstCarNumber = 5;
        int secondCarNumber = 2;
        List<ParkingLot> parkingLots = new LinkedList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        for (int carIndex = 0; carIndex < firstCarNumber; carIndex++) {
            firstParkingLot.park(new Car());
        }
        for (int carIndex = 0; carIndex < secondCarNumber; carIndex++) {
            secondParkingLot.park(new Car());
        }
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(firstCarNumber, parkingLots.get(0).getCurStock());
        assertEquals(secondCarNumber+1, parkingLots.get(1).getCurStock());

    }
}
