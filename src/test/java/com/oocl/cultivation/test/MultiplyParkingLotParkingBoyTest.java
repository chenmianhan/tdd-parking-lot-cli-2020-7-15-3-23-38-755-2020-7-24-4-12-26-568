package com.oocl.cultivation.test;


import com.oocl.cultivation.Car;
import com.oocl.cultivation.MultiplyParkingLotParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MultiplyParkingLotParkingBoyTest {
    @Test
    void should_fetch_null_car_when_fetch_given_no_ticket() {
        //given
        List<ParkingLot> parkingLots = new LinkedList<>();
        MultiplyParkingLotParkingBoy multiplyParkingLotParkingBoy=new MultiplyParkingLotParkingBoy(parkingLots);

        //when
        Car car =multiplyParkingLotParkingBoy.fetch(null);

        //then
        assertNull(car);
    }
}
