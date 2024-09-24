package ma.znagui.service;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;
import ma.znagui.repository.EstimateRepository;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;

public class EstimateService {
    EstimateRepositoryInterface repo = new EstimateRepository();
    public Estimate getEstimateProject(Project project){
        return repo.getEstimateProject(project);
    }
}
