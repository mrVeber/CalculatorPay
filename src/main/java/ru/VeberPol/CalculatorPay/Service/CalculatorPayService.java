package ru.VeberPol.CalculatorPay.Service;

import java.time.LocalDate;

public interface CalculatorPayService {
    String calculatePayWithHolidays(Double averageSalary, Integer vacationDays, LocalDate startDate);
    String calculatePay(Double averageSalary, Integer vacationDays);
}
