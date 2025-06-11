package jdbc.service;

import jdbc.dao.ClientServiceImpl;
import jdbc.model.Client;
import java.util.List;

public class ClientService {
    private final ClientServiceImpl clientServiceImpl;

    public ClientService(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    public long create(String name) {
        return clientServiceImpl.create(name);
    }


    public String getById(long id) {
        return clientServiceImpl.getById(id);
    }

    public void setName(long id, String name) {
        clientServiceImpl.setName(id, name);
    }


    public void deleteById(long id) {
        clientServiceImpl.deleteById(id);
    }

    public List<Client> listAll() {
        return clientServiceImpl.listAll();
    }
}
