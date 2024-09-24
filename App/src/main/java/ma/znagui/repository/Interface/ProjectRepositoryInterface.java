package ma.znagui.repository.Interface;

import ma.znagui.Model.Component;
import ma.znagui.Model.Project;

import java.util.List;

public interface ProjectRepositoryInterface {
    public Project addProject(Project project);
    public List<Project> getProjects();
    public Project getProject(int id);
    public boolean updateProject(Project oldProject, Project project);
    public boolean deleteProject(Project project);
    public List<Component> getProjectComponents(Project project);

}
