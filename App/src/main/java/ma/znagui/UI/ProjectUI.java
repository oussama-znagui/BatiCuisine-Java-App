package ma.znagui.UI;

import ma.znagui.Enum.ComponentType;
import ma.znagui.Enum.ProjectStatus;
import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Labor;
import ma.znagui.Model.Project;
import ma.znagui.service.ClientService;
import ma.znagui.service.ComponentService;
import ma.znagui.service.Interface.ClientServiceInterface;
import ma.znagui.service.Interface.ComponentServiceInterface;
import ma.znagui.service.Interface.ProjectServiceInterface;
import ma.znagui.service.ProjectService;
import main.java.ma.znagui.Model.Client;
import main.java.ma.znagui.UI.ClientUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectUI {
    private static Scanner scanner = new Scanner(System.in);
    private static ProjectServiceInterface projectService = new ProjectService();
    private static ComponentServiceInterface componentService = new ComponentService();
    private static ClientServiceInterface clientService = new ClientService();


    public static void projectMenu(){
        System.out.println("Gestion des Projets");
        System.out.println("---------------------");

        while(true){
            System.out.println("1 - Liste des Projets");
            System.out.println("2 - Ajouter un projet");
            System.out.println("3 - Modifier un projet");
            System.out.println("4 - Supprimer un projet");
            System.out.println("0 - Menu principal");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    projectService.displayAllProjects();
                    break;
                case 2:
                    addProject();
                    break;


            }
        }
    }


    public static void addProject(){
        System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        Client client = null;

        do {

            System.out.println("1 - Chercher un client existant");
            System.out.println("2 -  Ajouter un nouveau client");
            int option = scanner.nextInt();
            scanner.nextLine();
            if(option == 1){
                clientService.displayAllClients();
                System.out.println("---------------------");
                System.out.println("Client ID : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                client = clientService.getClient(id);
                break;

            }else if(option == 2){
                client = ClientUI.addClient();
                break;
            }
            else {
                System.out.println("Choix Invalide");
            }

        }while (true);

        System.out.println("Titre du projet : ");
        String titre = scanner.nextLine();
        Project p = new Project(0,titre,0,0, ProjectStatus.INPROGRESS,client);
        Project p1 = projectService.addProject(p);



        System.out.println("--- Ajout des matériaux ---");
        List<Component> components = new ArrayList<Component>();
        do{
            Component e = getEquipmentData();
            e.setProject(p1);
            components.add(e);
            System.out.println("Voulez-vous ajouter un autre matériau ? (y/n) :");
            String response = scanner.nextLine();
            if(response.equals("n") || response.equals("N")){
                break;
            }

        }while(true);

        System.out.println("--- Ajout de la main-d'oeuvre ---");
        do{
            Component l = getLaborData();
            l.setProject(p1);
            components.add(l);

            System.out.println("Voulez-vous ajouter un autre   main-d'œuvre ? (y/n) :");
            String response = scanner.nextLine();
            if(response.equals("n")){
                break;
            }

        }while(true);

        for(Component c : components){
            System.out.println(c);
        }

        componentService.addComponentsToProject(components);

        System.out.println("Souhaitez-vous appliquer une marge bénéficiaire au projet? (y/n) :");
        String response = scanner.nextLine();
        if(response.equals("y") || response.equals("Y")){
            System.out.println("Entrez le pourcentage de marge bénéficiaire: ");
            double pourcentage = scanner.nextDouble();
            scanner.nextLine();
            p1.setProfitMargin(pourcentage);
            System.out.println("------->>>" + p1);
            projectService.updateProject(p1,p1);

            System.out.println("Projet ajoute avec succes 1");
            System.out.println("Composants ajoutés avec succes 1");
            System.out.println("Marge bénéficiaire ajoutée avec succes 1");
            System.out.println("-----------------------------------------");
            System.out.println("Veullez Consulter la section Cout&Devis (3)");

        }


    }


    public static Component getLaborData(){
        System.out.println("Nom de main-d'œuvre : ");
        String name = scanner.nextLine();
        System.out.println("Taux TVA : ");
        int tva = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Taux horaire de cette main-d'œuvre (MAD/h) : ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nombre d'heures travaillées : ");
        double heureRate = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Facteur de productivité (EX : 1.3)");
        double productivity = scanner.nextDouble();
        scanner.nextLine();
        Component labor = new Labor(0,name,tva, ComponentType.LABOR,null,hourlyRate,heureRate,productivity);
        return labor;

    }

    public static Component getEquipmentData(){
        System.out.println("Nom du matériau : ");
        String name = scanner.nextLine();
        System.out.println("Taux TVA : ");
        int tva = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantité de ce matériau : ");
        double quantity = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Coût unitaire de ce matériau : ");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Coût de transport de ce matériau : ");
        double transport = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Coefficient de qualité : ");
        double quality = scanner.nextDouble();
        scanner.nextLine();

        Component eq = new Equipment(0,name,tva,ComponentType.EQUIPMENT,null,quantity,unitPrice,transport,quality);
        return eq;



    }
}
