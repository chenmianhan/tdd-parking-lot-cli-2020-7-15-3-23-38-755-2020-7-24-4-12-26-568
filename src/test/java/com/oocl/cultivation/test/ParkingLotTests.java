package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTests {
    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        Ticket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetching_car_given_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar = new Car();
        Ticket carTicket = parkingLot.park(parkedCar);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, parkedCar);
    }

    @Test
    void should_fetch_correspond_ticket_when_fetch_car_given_correspond_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 10;
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }

        //when
        for (Car car : parkedCars) {
            tickets.add(parkingLot.park(car));
        }
        List<Car> fetchedCars = new LinkedList<>();
        for (Ticket ticket : tickets) {
            fetchedCars.add(parkingLot.fetch(ticket));
        }

        //then
        for (int i = 0; i <carNumber; i++) {
            assertEquals(fetchedCars.get(i),parkedCars.get(i));
        }
    }
}
