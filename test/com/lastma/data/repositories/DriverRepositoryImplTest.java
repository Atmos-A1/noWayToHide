package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverRepositoryImplTest {

    private DriverRepositoryImpl driverRepository;
    private Driver driver;
    private Driver driverTwo;

    @BeforeEach
    public void setUp() {
        driverRepository = new DriverRepositoryImpl();
        driver = new Driver();
        driverTwo = new Driver();   // was missing before
    }

    @Test
    public void testThatWhenISaveOneDriver_numberOfDriversBecomesOne() {
        driverRepository.save(driver);
        assertEquals(1L, driverRepository.count());
    }

    @Test
    public void testThatWhenIAddTwoDrivers_numberOfDriversDouble() {
        assertEquals(0L, driverRepository.count());
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        assertEquals(2L, driverRepository.count());
    }

    @Test
    public void testThatWhenISaveDriver_IDIsSet() {
        driverRepository.save(driver);
        assertEquals(1, driver.getId());
    }

    @Test
    public void testThatSavedDriversGetDifferentIDs() {
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        assertEquals(1, driver.getId());
        assertEquals(2, driverTwo.getId());
    }

    @Test
    public void testThatWhenIFindByID_DriverIsFound() {
        driverRepository.save(driver);
        assertEquals(driver, driverRepository.findById(1));
    }

    @Test
    public void testThatFindByIdWithWrongID_ThrowsException() {
        driverRepository.save(driver);
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findById(99));
    }

    @Test
    public void testThatFindAllReturnsAllSavedDrivers() {
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        List<Driver> drivers = driverRepository.findAll();
        assertEquals(2, drivers.size());
        assertTrue(drivers.contains(driver));
        assertTrue(drivers.contains(driverTwo));
    }

    @Test
    public void testThatFindAllOnEmptyRepository_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findAll());
    }

    @Test
    public void testThatWhenIDeleteDriver_CountDecreases() {
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        driverRepository.delete(1);
        assertEquals(1L, driverRepository.count());
        assertThrows(IllegalArgumentException.class, () -> driverRepository.findById(1));
    }

    @Test
    public void testThatDeletingNonExistentDriver_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> driverRepository.delete(5));
    }

    @Test
    public void testThatWhenIDeleteAll_CountIsZero() {
        driverRepository.save(driver);
        driverRepository.save(driverTwo);
        driverRepository.deleteAll();
        assertEquals(0L, driverRepository.count());
    }
}