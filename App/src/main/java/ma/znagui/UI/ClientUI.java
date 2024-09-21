package main.java.ma.znagui.UI;

import ma.znagui.service.ClientService;
import ma.znagui.service.Interface.ClientServiceInterface;
import main.java.ma.znagui.Model.Client;

import java.util.Scanner;

public class ClientUI {

    public static Scanner scanner = new Scanner(System.in);
    private static ClientServiceInterface clientService = new ClientService();

    public static Client getData(){
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("phone: ");
        String phone = scanner.nextLine();
        System.out.print("isPro: ");
        boolean isPro = scanner.nextBoolean();
        scanner.nextLine();
        return new Client(0,name,email,phone,isPro);
    }

    public static Client addClient(){
        Client c = getData();
        clientService.addClient(c);
        System.out.println(clientService.addClient(c));
        return clientService.addClient(c);
    }

    public static void clientMenu(){
        System.out.println("Gestion Des Clients");
        System.out.println("--------------------");

        while (true){
            System.out.println("1 - List des clients");
            System.out.println("2 - Ajouter un client ");
            System.out.println("3 - Modifier un client ");
            System.out.println("4 - Supprimer un client ");
            System.out.println("0 - Menu principal");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
            }
        }


    }






}
