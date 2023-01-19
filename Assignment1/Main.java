package Assignment1;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Agent agent = new Agent(table);
        Chef breadChef = new Chef(table, 1);
        Chef jamChef = new Chef(table, 2);
        Chef peanutButterChef = new Chef(table, 3);
        Thread agentThread = new Thread(agent);
        Thread breadThread = new Thread(breadChef);
        Thread jamThread = new Thread(jamChef);
        Thread peanutThread = new Thread(peanutButterChef);
        agentThread.start();
        breadThread.start();
        jamThread.start();
        peanutThread.start();
    }
}
