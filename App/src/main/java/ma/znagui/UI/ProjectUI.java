package ma.znagui.UI;

import ma.znagui.Model.Project;
import ma.znagui.service.Interface.ProjectServiceInterface;
import ma.znagui.service.ProjectService;
import main.java.ma.znagui.Model.Client;

import java.util.Scanner;

public class ProjectUI {
    private static Scanner scanner = new Scanner(System.in);
    private static ProjectServiceInterface projectService = new ProjectService();

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
                    getData();


            }
        }
    }


    public static void getData(){
        System.out.println("Titre du projet : ");
        String titre = scanner.nextLine();

        System.out.println("--- Ajout des matériaux ---");
        do{
            //get data materiel
            System.out.println("Voulez-vous ajouter un autre matériau ? (y/n) :");
            String response = scanner.nextLine();
            if(response.equals("n")){
                break;
            }

        }while(true);

        System.out.println("--- Ajout de la main-d'oeuvre ---");
        do{
            //get data main-d'oeuvre
            System.out.println("Voulez-vous ajouter un autre type de main-d'œuvre ? (y/n) :");
            String response = scanner.nextLine();
            if(response.equals("n")){
                break;
            }

        }while(true);











    }
}
