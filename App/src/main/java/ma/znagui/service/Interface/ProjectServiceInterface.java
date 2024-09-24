package ma.znagui.service.Interface;

import ma.znagui.Model.Project;

public interface ProjectServiceInterface {
    public void displayAllProjects();
    public Project addProject(Project project);
    public boolean updateProject(Project oldProject, Project project);
    public Project getProject(int id);
}
