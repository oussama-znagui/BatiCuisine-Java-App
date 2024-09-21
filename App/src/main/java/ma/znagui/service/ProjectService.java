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
}
