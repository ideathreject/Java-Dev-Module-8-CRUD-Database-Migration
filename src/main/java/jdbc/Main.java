package jdbc;

public class Main {
    public static void main(String[] args) {
        //test purpose
        ClientService clientService = new ClientService(Database.getInstance());
        long id = clientService.create("Vladyslav");
        System.out.println("created with id "+ id);
        String name = clientService.getById(4);
        System.out.println("name = " + name);

    }
}
