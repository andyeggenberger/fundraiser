package co.agital.fundraiser.services;

import co.agital.fundraiser.entities.Site;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GeocoderServiceTest {

    private Logger logger = LoggerFactory.getLogger(GeocoderServiceTest.class);

    @Autowired
    private GeocoderService service;

    @Test
    void getLatLngForGoogleHeadquarter() {
        Site google = service.getLatLng("1600 Ampitheatre Parkway", "Mountain View", "CA");
        logger.info(google.toString());
        assertEquals(37.42, google.getLatitude(), 0.01);
        assertEquals(-122.08, google.getLongitude(), 0.01);
    }

    @Test
    public void getLatLngWithoutStreet() {
        Site site = service.getLatLng("Boston", "MA");
        logger.info(site.toString());
        assertAll(
                () -> assertEquals(42.36, site.getLatitude(), 0.01),
                () -> assertEquals(-71.06, site.getLongitude(), 0.01)
        );
    }

    @Test
    void getLatLngForHome() {
        Site google = service.getLatLng("Forchstrasse 75", "Egg", "ZH", "Switzerland");
        logger.info(google.toString());
        assertEquals(47.29, google.getLatitude(), 0.01);
        assertEquals(8.69, google.getLongitude(), 0.01);
    }

}
