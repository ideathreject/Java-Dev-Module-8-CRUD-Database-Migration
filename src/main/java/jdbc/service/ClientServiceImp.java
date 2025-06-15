package jdbc.service;

import jdbc.dao.ClientDaoImplService;
import jdbc.model.Client;
import static jdbc.service.ValidateUtil.validateId;
import static jdbc.service.ValidateUtil.validateName;

import java.util.List;

public class ClientServiceImp implements ClientService {
    private final ClientDaoImplService clientServiceImpl;

    public ClientServiceImp(ClientDaoImplService clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    public long create(String name) {
        validateName(name);
        return clientServiceImpl.create(name);
    }


    public String getById(long id) {
        validateId(id);
        return clientServiceImpl.getById(id);
    }

    public void setName(long id, String name) {
        validateName(name);
        clientServiceImpl.setName(id, name);
    }


    public void deleteById(long id) {
        validateId(id);
        clientServiceImpl.deleteById(id);
    }

    public List<Client> listAll() {
        return clientServiceImpl.listAll();
    }
}
