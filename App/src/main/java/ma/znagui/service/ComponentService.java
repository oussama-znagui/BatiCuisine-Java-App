package ma.znagui.service;

import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Labor;
import ma.znagui.repository.EquipmentRepository;
import ma.znagui.repository.Interface.EquipmentRepositoryInterface;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import ma.znagui.repository.LaborRepository;
import ma.znagui.service.Interface.ComponentServiceInterface;
import ma.znagui.service.Interface.EquipmentServiceInterface;
import ma.znagui.service.Interface.LaborServiceInterface;

import java.util.List;

public class ComponentService implements ComponentServiceInterface {
    private static LaborRepositoryInterface laborRepository = new LaborRepository();
    private static EquipmentRepositoryInterface equipmentRepository = new EquipmentRepository();
    private static EquipmentServiceInterface equipmentService = new EquipmentService();
    private static LaborServiceInterface laborService = new LaborService();


    public boolean addComponentsToProject(List<Component> components){
        components.stream().filter(component -> component instanceof Labor).forEach(component -> {laborRepository.addLabor((Labor) component);});
        components.stream().filter(component -> component instanceof Equipment).forEach(component -> {equipmentRepository.addEquipment((Equipment) component);});
        return true;
    }

    public double calculateComponentsCost(List<Component> components){

        double costLabors =  components.stream().filter(component -> component instanceof Labor)
                .map(component -> {
                    return laborService.CalculateSalary((Labor) component);

                }).reduce(0.0,Double::sum);

        double costMateriel = components.stream().filter(component -> component instanceof Equipment)
                .map(component -> {
                    return equipmentService.calculatePrice((Equipment) component);
                }).reduce(0.0,Double::sum);


        return costLabors + costMateriel;
    }



}
