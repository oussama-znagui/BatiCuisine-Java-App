package ma.znagui.UI;

import jdk.jshell.execution.Util;
import ma.znagui.Model.Component;
import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;
import ma.znagui.Util.DateValidation;
import ma.znagui.repository.EstimateRepository;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;
import ma.znagui.service.Interface.ProjectServiceInterface;
import ma.znagui.service.ProjectService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EstimateUI {
    public static Scanner scanner = new Scanner(System.in);
    private static ProjectServiceInterface projectService = new ProjectService();
    private static EstimateRepositoryInterface esprepo = new EstimateRepository();

    public static void getEstimate(Estimate estimate) {
        System.out.println("-------------------------------------------------------");
        System.out.println("\t\t\t\t\tDEVIS N° " + estimate.getId());
        System.out.println("-------------------------------------------------------");
        System.out.println("Ste BatiCuisine");
        System.out.println("Agadir, Maroc 80000");
        System.out.println("contact@BatiCuisine.ma");
        System.out.println("\t\t\t\t\t\t\t\tClient : " + estimate.getProject().getClient().getName());
        System.out.println("\t\t\t\t\t\t\t\tEmail : " + estimate.getProject().getClient().getEmail());
        System.out.println("\t\t\t\t\t\t\t\tTel : " + estimate.getProject().getClient().getPhone());
        System.out.println("-------------------------------------------------------");
        List<Component> = projectService
        for (for (Component c : components) {
            System.out.println(c);
        })




    }

    public static void estimateMenu(){
        System.out.println("coût d'un projet & devis");
        System.out.println("---------------------");

        while (true){
            System.out.println("1 - Visualiser le devis d'un projet");
            System.out.println("2 - Generer un devis");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1){
                getEstimate();
            }else if (option == 2){

                esprepo.addEstimate(getData());

            }
            else {
                System.out.println("Choix Invalide");
            }

        }
    }


    public static Estimate getData() {
        LocalDate date = null;
        LocalDate date2 = null;
        projectService.displayAllProjects();
        System.out.println("--------------------------------------------------");
        System.out.println("projet ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Project p = projectService.getProject(id);
        if (esprepo.getEstimateProject(p) != null){

            do {
                date = DateValidation.validationDate("Date de debut : (YYYY-MM-DD)");

                date2 = DateValidation.validationDate("Date de fin (YYYY-MM-DD)");

            }while (date.equals(date2) || date2.isBefore(date));

        }
        double total = p.getTotalCost() * (1+p.getProfitMargin()/100);
        return new Estimate(0,total,date,date2,false,p);





    }
}
