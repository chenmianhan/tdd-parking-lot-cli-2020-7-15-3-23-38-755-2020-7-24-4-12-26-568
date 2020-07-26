package com.oocl.cultivation.test;


import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.StandardParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void should_fetch_car_when_fetching_car_given_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        Car parkedCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Ticket carTicket = standardParkingBoy.park(parkedCar);

        //when
        Car fetchedCar = standardParkingBoy.fetch(carTicket);

        //then
        assertNotNull(fetchedCar);
        assertEquals(fetchedCar, parkedCar);
    }
    @Test
    void should_fetch_correspond_ticket_when_fetch_car_given_correspond_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 12;
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }

        //when
        for (Car car : parkedCars) {
            tickets.add(standardParkingBoy.park(car));
        }
        List<Car> fetchedCars = new LinkedList<>();
        for (Ticket ticket : tickets) {
            fetchedCars.add(standardParkingBoy.fetch(ticket));
        }

        //then
        for (int i = 0; i < carNumber; i++) {
            assertEquals(fetchedCars.get(i), parkedCars.get(i));
        }

    }
    @Test
    void should_fetch_null_car_when_fetch_given_a_wrong_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        Car parkedCar = new Car();
        standardParkingBoy.park(parkedCar);
        Ticket wrongTicket = new Ticket();

        //when
        Car fetchCar = standardParkingBoy.fetch(wrongTicket);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_fetch_null_car_and_return_unrecognized_parking_ticket_when_fetch_car_then_provide_the_used_ticket_and_query_message() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);

        //when
        Ticket usedTicket = standardParkingBoy.park(new Car());
        standardParkingBoy.fetch(usedTicket);
        Car fetchAgainCar = standardParkingBoy.fetch(usedTicket);
        //then
        assertNull(fetchAgainCar);
        assertEquals("Unrecognized park ticket.", standardParkingBoy.getErrorMessage());
    }

}
