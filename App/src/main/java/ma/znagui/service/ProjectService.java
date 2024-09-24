package ma.znagui.service;

import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.ProjectRepositoryInterface;
import ma.znagui.repository.ProjectRepository;
import ma.znagui.service.Interface.ProjectServiceInterface;

import java.util.List;

public class ProjectService implements ProjectServiceInterface {
    private ProjectRepositoryInterface repository = new ProjectRepository();


    public void displayAllProjects(){
        List<Project> projects = repository.getProjects();
        for(Project project : projects){
            System.out.println(project);
        }
    }

    public Project addProject(Project project){
        return repository.addProject(project);
    }

    public boolean updateProject(Project oldProject, Project project){
        return repository.updateProject(oldProject, project);
    }
    public Project getProject(int id){
        return repository.getProject(id);
    }
}
