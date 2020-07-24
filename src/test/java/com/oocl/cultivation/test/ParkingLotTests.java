package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTests {
    @Test
    void should_return_ticket_when_parking_car_given_car() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car car = new Car();

        //when
        Ticket carTicket = parkingBoy.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetching_car_given_ticket() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car parkedCar = new Car();
        Ticket carTicket = parkingBoy.park(parkedCar);

        //when
        Car fetchedCar = parkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, parkedCar);
    }

    @Test
    void should_fetch_correspond_ticket_when_fetch_car_given_correspond_ticket() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 10;
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
    void should_fetch_null_car_when_fetch_given_a_wrong_ticket() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car parkedCar = new Car();
        parkingBoy.park(parkedCar);
        Ticket wrongTicket = new Ticket();

        //when
        Car fetchCar = parkingBoy.fetch(wrongTicket);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_fetch_null_car_when_fetch_given_no_ticket() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car parkedCar = new Car();
        parkingBoy.park(parkedCar);

        //when
        Car fetchCar = parkingBoy.fetch(null);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_fetch_null_car_when_fetch_given_used_ticket() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car parkedCar = new Car();
        Ticket usedTicket = parkingBoy.park(parkedCar);
        parkingBoy.fetch(usedTicket);

        //when
        Car fetchAgainCar = parkingBoy.fetch(usedTicket);

        //then
        assertNull(fetchAgainCar);
    }

    @Test
    void should_return_null_ticket_when_park_car_given_parking_lot_full_capacity() {
        //given
        int carNumber=10;
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        List<Car> parkedCars = new LinkedList<>();
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }
        for (Car car : parkedCars) {
            parkingBoy.park(car);
        }

        //when
        Ticket ticket=parkingBoy.park(new Car());

        //then
        assertNull(ticket);
    }
}
