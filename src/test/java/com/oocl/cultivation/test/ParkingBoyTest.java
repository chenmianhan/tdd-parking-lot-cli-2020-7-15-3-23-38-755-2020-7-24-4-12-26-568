package com.oocl.cultivation.test;


import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.oocl.cultivation.ErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    private List<ParkingLot> parkingLots;
    private ParkingBoy parkingBoy;

    @BeforeEach
    void initTest() {
        parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        parkingBoy = new ParkingBoy(parkingLots);
    }
    @Test
    void should_parking_at_the_first_parking_lot_when_parking_car_given_five_cars() throws ParkingException {
        //given
        int carNumber = 5;
        //when
        for (int i = 0; i < carNumber; i++)
            parkingBoy.park(new Car());

        //then
        assertEquals(5, parkingLots.get(0).getCurStock());
        assertEquals(0, parkingLots.get(1).getCurStock());
    }

    @Test
    void should_parking_at_the_second_parking_lot_when_parking_car_given_the_first_parking_lot_full_11_cars() throws ParkingException {
        //given
        int carNumber = 11;

        //when
        for (int i = 0; i < carNumber; i++)
            parkingBoy.park(new Car());

        //then
        assertEquals(10, parkingLots.get(0).getCurStock());
        assertEquals(1, parkingLots.get(1).getCurStock());
    }

    @Test
    void should_fetch_null_car_when_fetch_given_a_wrong_ticket() throws ParkingException {
        //given
        Car parkedCar = new Car();
        parkingBoy.park(parkedCar);
        Ticket wrongTicket = new Ticket();

        try {
            //when
            Car fetchCar = parkingBoy.fetch(wrongTicket);

            //then
            assertNull(fetchCar);
        } catch (FetchException fetchException) {

        }
    }

    @Test
    void should_fetch_null_car_and_return_unrecognized_parking_ticket_when_fetch_car_then_provide_the_used_ticket_and_query_message() throws FetchException, ParkingException {
        //given

        //when
        Ticket usedTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(usedTicket);
        Throwable exception = assertThrows(FetchException.class, () -> {
            Car fetchAgainCar = parkingBoy.fetch(usedTicket);
            assertNull(fetchAgainCar);
        });

        //then
        Assertions.assertEquals(WRONGTICKET.getError(), exception.getMessage());

    }

    @Test
    void should_fetch_null_car_when_fetch_given_no_ticket() {
        //given

        try {
            //when
            Car car = parkingBoy.fetch(null);
            //then
            assertNull(car);
        } catch (FetchException fetchException) {

        }
    }



    @Test
    void should_return_not_enough_position_when_park_car_given_full_parking_lot() {
        //given
        int capacity = 10;
        parkingLots = new LinkedList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        for (int i = 0; i < capacity; i++) {
            parkingLot1.park(new Car());
            parkingLot2.park(new Car());
        }
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when

        Throwable exception = assertThrows(ParkingException.class, () -> {
            parkingBoy.park(new Car());
        });

        //then
        Assertions.assertEquals(NOTSPACE.getError(), exception.getMessage());
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_given_wrong_ticket() throws ParkingException {
        //given

        //when
        parkingBoy.park(new Car());
        Throwable exception = assertThrows(FetchException.class, () -> {
            parkingBoy.fetch(new Ticket());
        });

        //then
        Assertions.assertEquals(WRONGTICKET.getError(), exception.getMessage());
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_fetch_car_given_no_ticket() {
        //given

        //when
        Throwable exception = assertThrows(FetchException.class, () -> {
            parkingBoy.fetch(null);
        });

        //then
        Assertions.assertEquals(NOTTICKET.getError(), exception.getMessage());
    }

}
