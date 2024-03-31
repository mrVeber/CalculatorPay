package ru.VeberPol.CalculatorPay.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.VeberPol.CalculatorPay.Service.ServiceImpl.CalculatorPayServiceImpl;

import java.time.LocalDate;

class CalculatorPayControllerTest {

    private CalculatorPayServiceImpl calculatorService;

    @BeforeEach
    void setUp(){
        calculatorService = new CalculatorPayServiceImpl();
    }
    @Test
    void testCalculateWithHolidays(){
        String actual = calculatorService.calculatePayWithHolidays(700000.00,
                30, LocalDate.of(2024, 2, 1));
        String expected = "41808.87372013652";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalculate(){
        String actual = calculatorService.calculatePay(700000.00, 30);
        String expected = "59726.96245733789";
        Assertions.assertEquals(expected, actual);
    }
}