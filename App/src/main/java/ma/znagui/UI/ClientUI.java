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






}
