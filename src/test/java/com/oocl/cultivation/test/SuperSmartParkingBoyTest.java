package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void should_fetch_car_when_fetching_car_given_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        Car parkedCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Ticket carTicket = superSmartParkingBoy.park(parkedCar);

        //when
        Car fetchedCar = superSmartParkingBoy.fetch(carTicket);

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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        List<Car> parkedCars = new LinkedList<>();
        List<Ticket> tickets = new LinkedList<>();
        int carNumber = 12;
        for (int i = 0; i < carNumber; i++) {
            parkedCars.add(new Car());
        }

        //when
        for (Car car : parkedCars) {
            tickets.add(superSmartParkingBoy.park(car));
        }
        List<Car> fetchedCars = new LinkedList<>();
        for (Ticket ticket : tickets) {
            fetchedCars.add(superSmartParkingBoy.fetch(ticket));
        }

        //then
        for (int i = 0; i < carNumber; i++) {
            assertEquals(fetchedCars.get(i), parkedCars.get(i));
        }

    }
}

