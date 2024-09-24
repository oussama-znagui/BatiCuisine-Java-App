package ma.znagui.repository.Interface;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;

public interface EstimateRepositoryInterface  {
    public boolean addEstimate(Estimate estimate);
    public Estimate getEstimateProject(Project project);

}
