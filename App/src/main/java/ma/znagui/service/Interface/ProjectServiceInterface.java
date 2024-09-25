package ma.znagui.service.Interface;

import ma.znagui.Model.Component;
import ma.znagui.Model.Project;

import java.util.List;

public interface ProjectServiceInterface {
    public void displayAllProjects();
    public Project addProject(Project project);
    public boolean updateProject(Project oldProject, Project project);
    public Project getProject(int id);
    public List<Component> getProjectComponents(Project project);
}
