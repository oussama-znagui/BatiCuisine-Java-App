package main.java.ma.znagui;

//import org.example.Model.Client;

import ma.znagui.Enum.ComponentType;
import ma.znagui.Enum.ProjectStatus;
import ma.znagui.Model.Component;
import ma.znagui.Model.Labor;
import ma.znagui.Model.Project;
import ma.znagui.UI.MainMenu;
import ma.znagui.service.ClientService;
import ma.znagui.service.ComponentService;
import ma.znagui.service.Interface.ClientServiceInterface;
import ma.znagui.service.Interface.ComponentServiceInterface;
import main.java.ma.znagui.Model.Client;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//  System.out.println("Hello World!");
//  int i = 4;
//  i++;
//  System.out.println(i);
//
//        Client client = new Client(1,"oussama","ada","adcz",false);
//        Client client2 = new Client(4,"fahd","aloooo","adcz",true);
//      System.out.println(client);

//        main.java.ma.znagui.UI.ClientUI.addClient();
//
//        ClientServiceInterface clientService = new ClientService();
//        clientService.updateClient(client,client2);
//        System.out.println("modifier");
//        System.out.println(clientService.getClient(10));
//        clientService.deleteClient(client2);
//        System.out.println("supp");


//        MainMenu.mainMenu();
        Client c1 = new Client(1,"hachem","svgr@zrg.e","36343",true);
        Project p1 = new Project(1,"c hj",12,33, ProjectStatus.valueOf("CANCELLED"),c1);

        Component l1 = new Labor(1,"hamid",20, ComponentType.valueOf("LABOR"),p1,12,33,1);
        List<Component> cmps = new ArrayList<Component>();
        cmps.add(l1);
        ComponentServiceInterface cs = new ComponentService();
        System.out.println(cs.calculateComponentsCost(cmps));


//
//        System.out.println(l1.getProject().getClient().getEmail());









    }

}