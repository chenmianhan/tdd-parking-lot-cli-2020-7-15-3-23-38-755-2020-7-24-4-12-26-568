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
    private ParkingLot firstParkingLot;
    private ParkingLot secondParkingLot;

    @BeforeEach
    void initTest() {
        parkingLots = new LinkedList<>();
        firstParkingLot = new ParkingLot();
        secondParkingLot = new ParkingLot();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
    }
    @Test
    void should_parking_at_the_first_parking_lot_when_parking_car_given_five_cars() throws ParkingException {
        //given
        int carNumber = 5;
        //when
        for (int i = 0; i < carNumber; i++)
            parkingBoy.park(new Car());

        //then
        assertEquals(5, firstParkingLot.getCurStock());
        assertEquals(0, secondParkingLot.getCurStock());
    }

    @Test
    void should_parking_at_the_second_parking_lot_when_parking_car_given_the_first_parking_lot_full_11_cars() throws ParkingException {
        //given
        int carNumber = 11;

        //when
        for (int i = 0; i < carNumber; i++)
            parkingBoy.park(new Car());

        //then
        assertEquals(10, firstParkingLot.getCurStock());
        assertEquals(1, secondParkingLot.getCurStock());
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
    void should_fetch_car_when_fetching_car_given_ticket() throws FetchException, ParkingException {
        //given
        Car parkedCar = new Car();
        Ticket carTicket = parkingBoy.park(parkedCar);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, parkedCar);
    }

    @Test
    void should_fetch_correspond_ticket_when_fetch_car_given_correspond_ticket() throws FetchException, ParkingException {
        //given

        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 12;
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }

        //when
        for (Car car : parkedCars) {
            tickets.add(parkingBoy.park(car));
        }
        List<Car> fetchedCars = new LinkedList<>();
        for (Ticket ticket : tickets) {
            fetchedCars.add(parkingBoy.fetch(ticket));
        }

        //then
        for (int i = 0; i < carNumber; i++) {
            assertEquals(fetchedCars.get(i), parkedCars.get(i));
        }

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
        for (int i = 0; i < capacity; i++) {
            firstParkingLot.park(new Car());
            secondParkingLot.park(new Car());
        }
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);

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

    @Test
    void should_return_unrecognized_parking_ticket_when_fetch_car_given_the_used_ticket() throws FetchException, ParkingException {
        //given

        //when
        Ticket usedTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(usedTicket);
        Throwable exception = assertThrows(FetchException.class, () -> {
            parkingBoy.fetch(usedTicket);
        });

        //then
        Assertions.assertEquals(WRONGTICKET.getError(), exception.getMessage());

    }
}
