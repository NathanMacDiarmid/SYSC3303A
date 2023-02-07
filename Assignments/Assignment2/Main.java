package Assignment2;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Host host = new Host();
        Client client = new Client();

        for (int i = 1; i < 11; i++) {
            client.send();
            host.receiveFromClient();
            host.sendToServer();
            server.receive();
            server.send();
            host.receiveFromServer();
            host.sendToClient();
            client.receive();
            System.out.println("\nThe Client has sent and received " + i + " messages!\n\n");
        }

        server.closeSocket();
        host.closeSocket();
        client.closeSocket();
    }
}
