package ma.znagui.service;

import ma.znagui.Model.Equipment;
import ma.znagui.service.Interface.EquipmentServiceInterface;

public class EquipmentService implements EquipmentServiceInterface {

    public double calculatePrice(Equipment equipment){
        double priceHT = equipment.getUnitCost() * equipment.getQuantity() * equipment.getQualityCoefficient();
        double tva = priceHT * equipment.getTva() / 100;
        return priceHT + tva + equipment.getTransportCost();
    }
}
