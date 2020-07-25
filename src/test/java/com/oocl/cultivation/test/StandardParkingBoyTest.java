package com.oocl.cultivation.test;


import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StandardParkingBoyTest {

    @Test
    void should_parking_at_the_first_parking_lot_when_parking_car_given_five_cars() {
        //given
        int carNumber = 5;
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        //when
        for (int i = 0; i < carNumber; i++)
            standardParkingBoy.park(new Car());

        //then
        assertEquals(5, parkingLots.get(0).getCurStock());
        assertEquals(0, parkingLots.get(1).getCurStock());
    }

    @Test
    void should_parking_at_the_second_parking_lot_when_parking_car_given_the_first_parking_lot_full_11_cars() {
        //given
        int carNumber = 11;
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        //when
        for (int i = 0; i < carNumber; i++)
            standardParkingBoy.park(new Car());

        //then
        assertEquals(10, parkingLots.get(0).getCurStock());
        assertEquals(1, parkingLots.get(1).getCurStock());
    }

    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket carTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }


}
