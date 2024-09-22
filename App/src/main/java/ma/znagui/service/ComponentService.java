package ma.znagui.service;

import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Labor;
import ma.znagui.repository.EquipmentRepository;
import ma.znagui.repository.Interface.EquipmentRepositoryInterface;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import ma.znagui.repository.LaborRepository;
import ma.znagui.service.Interface.ComponentServiceInterface;

import java.util.List;

public class ComponentService implements ComponentServiceInterface {
    private LaborRepositoryInterface laborRepository = new LaborRepository();
    private EquipmentRepositoryInterface equipmentRepository = new EquipmentRepository();


    public boolean addComponentsToProject(List<Component> components){
        components.stream().filter(component -> component instanceof Labor).forEach(component -> {laborRepository.addLabor((Labor) component);});
        components.stream().filter(component -> component instanceof Equipment).forEach(component -> {equipmentRepository.addEquipment((Equipment) component);});


        return true;
    }

}
