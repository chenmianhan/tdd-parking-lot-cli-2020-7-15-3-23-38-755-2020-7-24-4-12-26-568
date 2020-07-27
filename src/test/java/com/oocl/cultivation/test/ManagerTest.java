package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManagerTest {

    @Test
    void should_return_four_ticket_when_parking_three_car_given_one_parkingLot_three_parkingBoy() throws ParkingException {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(1));
        ParkingLot parkingLot = new ParkingLot(1);
        Manager manager = new Manager(parkingBoy, smartParkingBoy, smartParkingBoy, superSmartParkingBoy, parkingLot);
        List<Ticket> tickets = new LinkedList<>();

        //when
        for (int carIndex = 0; carIndex < 4; carIndex++) {
            tickets.add(manager.park(new Car()));
        }

        //then
        for (Ticket ticket : tickets) {
            assertNotNull(ticket);
        }
    }

    @Test
    void should_return_one_ticket_when_parking_a_car_given_add_one_parking_boy() throws ParkingException {
        //given
        Manager manager = new Manager();
        manager.addParkingBoy(new ParkingBoy(new ParkingLot(1)));

        //when
        Ticket ticket = manager.park(new Car());

        //then
        assertNotNull(ticket);
    }
}
