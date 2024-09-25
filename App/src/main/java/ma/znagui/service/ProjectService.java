package ma.znagui.service;

import ma.znagui.Model.Component;
import ma.znagui.Model.Project;
import ma.znagui.repository.EquipmentRepository;
import ma.znagui.repository.EstimateRepository;
import ma.znagui.repository.Interface.EquipmentRepositoryInterface;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import ma.znagui.repository.Interface.ProjectRepositoryInterface;
import ma.znagui.repository.LaborRepository;
import ma.znagui.repository.ProjectRepository;
import ma.znagui.service.Interface.ProjectServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements ProjectServiceInterface {
    private static ProjectRepositoryInterface repository = new ProjectRepository();
    private static LaborRepositoryInterface lrep =  new LaborRepository();
    private static EquipmentRepositoryInterface erep = new EquipmentRepository();


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

    public List<Component> getProjectComponents(Project project){



        List<Component> cpmnts = new ArrayList<Component>();
        cpmnts.addAll(lrep.getProjectLabors(project));
        cpmnts.addAll(erep.getProjectEquipments(project));

        return cpmnts;
    }
}
