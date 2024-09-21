package ma.znagui.service.Interface;
import main.java.ma.znagui.Model.Client;

import java.util.List;

public interface ClientServiceInterface {
    public Client addClient(Client client);
    public Client getClient(int id);
    public boolean updateClient(Client oldClient, Client client);
    public List<Client> getClients();
    public boolean deleteClient(Client client);
    public void displayAllClients();

}
