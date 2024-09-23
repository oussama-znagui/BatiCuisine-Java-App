package ma.znagui.service.Interface;

import ma.znagui.Model.Component;

import java.util.List;

public interface ComponentServiceInterface {
    public boolean addComponentsToProject(List<Component> components);
    public double calculateComponentsCost(List<Component> components);
}
