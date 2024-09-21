package ma.znagui.UI;

import java.util.Scanner;

public class ProjectUI {
    public static Scanner scanner = new Scanner(System.in);

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

            }
        }
    }
}
