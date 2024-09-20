package ma.znagui.service;

import ma.znagui.repository.ClientRepository;
import ma.znagui.repository.Interface.ClientRepositoryInterface;
import ma.znagui.service.Interface.ClientServiceInterface;
import main.java.ma.znagui.Model.Client;

public class ClientService implements ClientServiceInterface {

    private ClientRepositoryInterface clientRepository = new ClientRepository();


    public Client addClient(Client client) {
        return clientRepository.addClient(client);
    }


}
