package com.oocl.cultivation.test;

import com.oocl.cultivation.Manager;
import com.oocl.cultivation.MultiplyParkingLotParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
