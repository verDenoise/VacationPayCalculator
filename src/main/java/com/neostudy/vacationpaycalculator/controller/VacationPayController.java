package com.neostudy.vacationpaycalculator.controller;

import com.neostudy.vacationpaycalculator.model.VacationPay;
import com.neostudy.vacationpaycalculator.service.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping()
public class VacationPayController {

    @Autowired
    private VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public String VacationPayCalculate() {
        return vacationPayService.vacationPayCalculating();
    }

    @GetMapping(value = "/calculate", params = {"averageSalary", "quantityVacationDays"})
    public String VacationPayCalculate(
            @RequestParam Double averageSalary,
            @RequestParam Integer quantityVacationDays) {

        return vacationPayService.vacationPayCalculating(new VacationPay(averageSalary, quantityVacationDays));
    }

    @GetMapping(value = "/calculate", params = {"averageSalary", "beginningVacation", "endVacation"})
    public String VacationPayCalculate(
            @RequestParam Double averageSalary,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beginningVacation,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endVacation) {

        return vacationPayService.vacationPayCalculating(new VacationPay(averageSalary, beginningVacation, endVacation));
    }
}
