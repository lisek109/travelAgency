package com.project.travelAgency.integrationTests;


import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.service.HotelService;
import com.project.travelAgency.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(value = TestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private HotelService hotelService;

    @Test
    void whenSavingHotel_thenOK() {
        Hotel result = hotelService.save(new Hotel(3L, "Hilton", (short) 5));

        assertNotNull(result);
    }
}
