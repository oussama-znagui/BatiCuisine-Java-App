package ma.znagui.UI;

import java.util.Scanner;

import ma.znagui.Model.Project;
import main.java.ma.znagui.UI.ClientUI;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static void  mainMenu(){

        int option = 0;
        System.out.println("Bienvenue dans l'application de gestion des projets de rénovation de cuisines");
        System.out.println("------------------------------------------------------------------------------");
      do{

          System.out.println("1 - Gestion des Clientes");
          System.out.println("2 - Gestion des Projets");
          System.out.println("3 - Calculer le coût d'un projet & devis");
          try {
              option = scanner.nextInt();
              scanner.nextLine();
          }catch (Exception e){
              System.out.println("Choix Invalide");
          }
          scanner.nextLine();

          switch(option){
              case 1:
                  ClientUI.clientMenu();
                  break;
              case 2:
                  ProjectUI.projectMenu();
                  break;
              case 3:
                  EstimateUI.estimateMenu();
                  break;
                  default:
                      System.out.println("Choix Invalide");




          }


      }while (true);

    }
}
