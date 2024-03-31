package ru.VeberPol.CalculatorPay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import ru.VeberPol.CalculatorPay.Service.ServiceImpl.CalculatorPayServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
public class CalculatorPayController {
    @Autowired
    private CalculatorPayServiceImpl calculatorPayService;

    @GetMapping("/calculacte")
    public String calculacte(@RequestParam(value = "averageSalary", required = true) Double averageSalary,
                             @RequestParam(value = "vacationDays", required = true) Integer vacationDays,
                             @RequestParam(value = "startDate", required = false)
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        String vacationPayments;

        if (startDate != null) {
            vacationPayments = calculatorPayService.calculatePayWithHolidays(averageSalary, vacationDays, startDate);
        } else {
            vacationPayments = calculatorPayService.calculatePay(averageSalary, vacationDays);
        }
        return vacationPayments;
    }
}
