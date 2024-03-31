package ru.VeberPol.CalculatorPay.Service.ServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static ru.VeberPol.CalculatorPay.Service.ServiceImpl.CalculatorPayServiceImpl.getVacationDaysWithHolidays;

class CalculatorPayServiceImplTest {
    private CalculatorPayServiceImpl calculatorService;

    @BeforeEach
    void setUp(){
        calculatorService = new CalculatorPayServiceImpl();
    }

    @Test
    void testGetVacationDaysWithHolidays(){
        int actual = getVacationDaysWithHolidays(LocalDate.of(2024, 2, 1), 30);
        int expected = 21;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculatePay(){
        String actual = calculatorService.calculatePay(700000.00, 30);
        String expected = "59726.96245733789";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculatePayWithInvalidParameters(){
        String actual = calculatorService.calculatePay(-700000.00, -30);
        String expected = "0.0";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculatePayWithHolidays(){
        String actual = calculatorService.calculatePayWithHolidays(700000.00,
                30, LocalDate.of(2024, 2, 1));
        String expected = "41808.87372013652";
        Assertions.assertEquals(expected, actual);
    }
}