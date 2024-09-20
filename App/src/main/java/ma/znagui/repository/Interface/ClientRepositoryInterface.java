package ma.znagui.repository.Interface;
import main.java.ma.znagui.Model.Client;

import java.util.List;

public interface ClientRepositoryInterface {
    public Client addClient(Client client);
    public Client getClient(int id);
    public boolean UpdateClient(Client oldClient, Client client);
    public List<Client> getClients();
    public boolean deleteClient(Client client);
}
