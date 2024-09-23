package ma.znagui.Model;

import ma.znagui.Enum.ComponentType;

public class Equipment extends Component {
    private double unitCost;
    private double quantity;
    private double transportCost;
    private double qualityCoefficient;

    public Equipment() {
        super();
    }

    public Equipment(int id, String name, int tva, ComponentType type, Project project,double unitCost, double quantity, double transportCost, double qualityCoefficient) {
        super(id, name, tva, type, project);
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public double getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTransportCost() {
        return transportCost;
    }
    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }
    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }

    public String toString() {
        return super.toString() + " ---> cout Unitaire : " + unitCost + ", quantity : " + quantity + ", transport : " + transportCost + ", quality : " + qualityCoefficient ;
    }
}
