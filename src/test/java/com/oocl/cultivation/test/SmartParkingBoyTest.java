package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.oocl.cultivation.ErrorMessage.WRONGTICKET;
import static org.junit.jupiter.api.Assertions.*;


class SmartParkingBoyTest {
    @Test
    void should_park_at_the_more_empty_parking_lot_when_parking_car_given_two_different_stock_parking_lot() throws ParkingException {
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
    @Test
    void should_fetch_car_when_fetching_car_given_ticket() throws FetchException, ParkingException {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        Car parkedCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Ticket carTicket = smartParkingBoy.park(parkedCar);

        //when
        Car fetchedCar = smartParkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, parkedCar);
    }
    @Test
    void should_fetch_correspond_ticket_when_fetch_car_given_correspond_ticket() throws FetchException, ParkingException {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 12;
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }

        //when
        for (Car car : parkedCars) {
            tickets.add(smartParkingBoy.park(car));
        }
        List<Car> fetchedCars = new LinkedList<>();
        for (Ticket ticket : tickets) {
            fetchedCars.add(smartParkingBoy.fetch(ticket));
        }

        //then
        for (int i = 0; i < carNumber; i++) {
            assertEquals(fetchedCars.get(i), parkedCars.get(i));
        }

    }
    @Test
    void should_fetch_null_car_when_fetch_given_a_wrong_ticket() throws FetchException, ParkingException {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car parkedCar = new Car();
        smartParkingBoy.park(parkedCar);
        Ticket wrongTicket = new Ticket();

        //when
        Car fetchCar = smartParkingBoy.fetch(wrongTicket);

        //then
        assertNull(fetchCar);
    }
    @Test
    void should_fetch_null_car_and_return_unrecognized_parking_ticket_when_fetch_car_then_provide_the_used_ticket_and_query_message() throws FetchException, ParkingException {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Ticket usedTicket = smartParkingBoy.park(new Car());
        smartParkingBoy.fetch(usedTicket);
        Car fetchAgainCar = smartParkingBoy.fetch(usedTicket);
        Throwable exception = assertThrows(FetchException.class, () -> {
            smartParkingBoy.fetch(usedTicket);
        });

        //then
        assertNull(fetchAgainCar);
        Assertions.assertEquals(WRONGTICKET.getError(), exception.getMessage());
    }
}
