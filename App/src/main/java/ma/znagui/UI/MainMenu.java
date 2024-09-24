package ma.znagui.UI;

import java.util.Scanner;

import ma.znagui.Model.Project;
import main.java.ma.znagui.UI.ClientUI;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static void  mainMenu(){
        int i = 0;
        System.out.println("Bienvenue dans l'application de gestion des projets de rénovation de cuisines");
        System.out.println("------------------------------------------------------------------------------");
      do{
          if(i != 0){ System.out.println("Choix Invalide");}
          System.out.println("1 - Gestion des Clientes");
          System.out.println("2 - Gestion des Projets");
          System.out.println("3 - Calculer le coût d'un projet & devis");
          int option = scanner.nextInt();
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




          }
          i++;

      }while (true);

    }
}
