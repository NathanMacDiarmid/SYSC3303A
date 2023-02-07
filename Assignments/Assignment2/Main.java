package Assignment2;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Host host = new Host();
        Client client = new Client();

        client.send();
        host.receiveFromClient();
        host.sendToServer();
        server.receive();
        server.send();
        host.receiveFromServer();
        host.sendToClient();
        client.receive();
    }
}
