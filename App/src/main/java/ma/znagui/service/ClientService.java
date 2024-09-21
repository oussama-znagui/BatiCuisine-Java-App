package ma.znagui.service;

import ma.znagui.repository.ClientRepository;
import ma.znagui.repository.Interface.ClientRepositoryInterface;
import ma.znagui.service.Interface.ClientServiceInterface;
import main.java.ma.znagui.Model.Client;

import java.util.List;

public class ClientService implements ClientServiceInterface {

    private ClientRepositoryInterface clientRepository = new ClientRepository();


    public Client addClient(Client client) {
        return clientRepository.addClient(client);
    }

    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClient(id);
    }

    public boolean updateClient(Client oldClient, Client client) {
        return clientRepository.UpdateClient(oldClient, client);
    }

    public boolean deleteClient(Client client) {
        return clientRepository.deleteClient(client);
    }


    public void displayAllClients() {
        List<Client> clients = clientRepository.getClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }


}
