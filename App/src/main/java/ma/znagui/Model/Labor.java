package ma.znagui.Model;

import ma.znagui.Enum.ComponentType;

public class Labor extends Component {
    private double hourlyRate;
    private double workingHours;
    private double productivityCff;

    public Labor(int id, String name, int tva, ComponentType type,Project project,double hourlyRate, double workingHours, double productivityCff) {
        super(id, name, tva, type,project);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
        this.productivityCff = productivityCff;
    }

    public Labor(){
        super();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkingHours() {
        return workingHours;
    }
    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getProductivityCff() {
        return productivityCff;
    }
    public void setProductivityCff(double productivityCff) {
        this.productivityCff = productivityCff;
    }

    public String toString(){
        return super.toString() + " ---> taux Horaire : " + hourlyRate + "heures Travail : " + workingHours + "heures Cff : " + productivityCff;
    }

}
