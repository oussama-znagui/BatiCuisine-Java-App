package ma.znagui.service;

import ma.znagui.Model.Labor;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import ma.znagui.service.Interface.LaborServiceInterface;

public class LaborService implements LaborServiceInterface {

    public double CalculateSalary(Labor labor){
        double salaryHT = (labor.getHourlyRate() * labor.getWorkingHours()) * labor.getProductivityCff();
        double tva = salaryHT * labor.getTva() / 100;
        return salaryHT + tva;
    }

}
