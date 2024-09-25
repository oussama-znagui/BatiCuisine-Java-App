package ma.znagui.service.Interface;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;

public interface EstimateServiceInterface {

    public boolean addEstimate(Estimate estimate);
    public Estimate getEstimateProject(Project project);
    public void displayAllEstimates();
    public boolean updateEstimate(Estimate estimate);
}
