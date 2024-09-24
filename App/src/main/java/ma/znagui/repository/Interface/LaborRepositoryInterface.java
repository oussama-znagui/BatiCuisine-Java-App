package ma.znagui.repository.Interface;

import ma.znagui.Model.Component;
import ma.znagui.Model.Labor;
import ma.znagui.Model.Project;

import java.util.List;

public interface LaborRepositoryInterface {

    public void addLabor(Labor lab);
    public List<Component> getProjectLabors(Project project);
}
