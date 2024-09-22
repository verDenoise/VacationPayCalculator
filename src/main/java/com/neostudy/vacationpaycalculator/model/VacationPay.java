package com.neostudy.vacationpaycalculator.model;

import java.time.LocalDate;

public class VacationPay {

    public final static Double AVERAGE_MONTHLY_NUMBER_OF_DAYS = 29.3;
    private Double averageSalary;
    private Integer quantityVacationDays;
    private LocalDate beginningVacation;
    private LocalDate endVacation;
    private String mistakes = "";

    public VacationPay(Double averageSalary, Integer quantityVacationDays) {

        if (averageSalaryIsCorrect(averageSalary)) {
            this.averageSalary = averageSalary;
        }

        if (quantityVacationDaysIsCorrect(quantityVacationDays)) {
            this.quantityVacationDays = quantityVacationDays;
        }
    }

    public VacationPay(Double averageSalary, LocalDate beginningVacation, LocalDate endVacation) {

        if (averageSalaryIsCorrect(averageSalary)) {
            this.averageSalary = averageSalary;
        }

        if (DatesIsCorrect(beginningVacation, endVacation)) {
            this.beginningVacation = beginningVacation;
            this.endVacation = endVacation;
        }
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public Integer getQuantityVacationDays() {
        return quantityVacationDays;
    }

    public LocalDate getBeginningVacation() {
        return beginningVacation;
    }

    public LocalDate getEndVacation() {
        return endVacation;
    }

    public String getMistakes() {
        return mistakes;
    }

    private boolean averageSalaryIsCorrect(Double averageSalary) {

        if (averageSalary <= 0) {
            this.mistakes += "Зарплата за 12 месяцев не может быть меньше или равна нулю.";
            return false;
        }

        return true;
    }

    private boolean quantityVacationDaysIsCorrect(Integer quantityVacationDays) {

        if (quantityVacationDays < 1) {
            this.mistakes += "Количество дней отпуска не может быть меньше 1";
            return false;
        }

        if (quantityVacationDays > 56) {
            this.mistakes += "В календарном году работник может взять не более 56 дней отпуска";
            return false;
        }

        return true;
    }

    private boolean DatesIsCorrect(LocalDate beginningVacation, LocalDate endVacation) {

        if (!beginningVacation.isBefore(endVacation)) {
            this.mistakes += "Дата начала не может быть больше даты окончания отпуска.";
            return false;
        }

        Integer quantityVacationDays = CalenderOfWorkingDays.getQuantityVacationDays(beginningVacation, endVacation);
        if (!quantityVacationDaysIsCorrect(quantityVacationDays)) {
            return false;
        }

        if (beginningVacation.isBefore(LocalDate.now())) {
            this.mistakes += "Отпуск не может быть расчиатан ранее текущей даты.";
            return false;
        }

        return true;
    }

    public boolean IsMistakes() {
        return !mistakes.isEmpty();
    }
}

