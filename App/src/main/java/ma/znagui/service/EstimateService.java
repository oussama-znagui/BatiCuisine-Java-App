package ma.znagui.service;

import ma.znagui.Model.Component;
import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;
import ma.znagui.repository.EstimateRepository;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;
import ma.znagui.service.Interface.EstimateServiceInterface;

import java.util.List;

public class EstimateService implements EstimateServiceInterface {
    EstimateRepositoryInterface repo = new EstimateRepository();


    public boolean addEstimate(Estimate estimate){
        return repo.addEstimate(estimate);
    }
    public Estimate getEstimateProject(Project project){
        return repo.getEstimateProject(project);
    }


    public void displayAllEstimates(){
        List<Estimate> components = repo.getAllEstimates();
        for(Estimate component : components){
            System.out.println(component);
        }
    }

    public boolean updateEstimate(Estimate estimate) {
        return repo.updateEstimate(estimate);
    }

}
