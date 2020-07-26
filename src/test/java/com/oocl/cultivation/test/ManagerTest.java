package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManagerTest {

    @Test
    void should_return_true_when_add_a_parking_boy_to_manage_list_when_given_a_parking_boy() {
        //given
        Manager parkingManager = new Manager();
        MultiplyParkingLotParkingBoy parkingBoy = new MultiplyParkingLotParkingBoy(new LinkedList<>());

        //when
        parkingManager.addParkingBoy(parkingBoy);

        //then
        List<MultiplyParkingLotParkingBoy> multiplyParkingLotParkingBoys = parkingManager.getParkingBotList();
        assertEquals(parkingBoy, multiplyParkingLotParkingBoys.get(multiplyParkingLotParkingBoys.size() - 1));
    }

    @Test
    void should_return_ticket_when_specify_a_parking_boy_parking_car_given_a_car() {
        //given
        Manager parkingManager = new Manager();
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        MultiplyParkingLotParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        parkingManager.addParkingBoy(parkingBoy);

        //when
        Ticket ticket = parkingManager.park(parkingBoy, new Car());

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_specify_a_parking_boy_fetch_a_car_given_having_been_parked_car() {
        //given
        Manager parkingManager = new Manager();
        List<ParkingLot> parkingLots = new LinkedList<>();
        parkingLots.add(new ParkingLot());
        MultiplyParkingLotParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        parkingManager.addParkingBoy(parkingBoy);
        Car parkedCar = new Car();

        //when
        Ticket ticket = parkingManager.park(parkingBoy, parkedCar);
        Car fetchedCar = parkingManager.fetch(parkingBoy, ticket);

        //then
        assertEquals(parkedCar, fetchedCar);
    }
}
