package ma.znagui.repository.Interface;

import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Project;

import java.util.List;

public interface EquipmentRepositoryInterface {
    public void addEquipment(Equipment equipment);
    public List<Component> getProjectEquipments(Project project);

}
