package ma.znagui.repository.Interface;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;

import java.util.List;

public interface EstimateRepositoryInterface  {
    public boolean addEstimate(Estimate estimate);
    public Estimate getEstimateProject(Project project);
    public List<Estimate> getAllEstimates();
    public boolean updateEstimate(Estimate estimate);
}
