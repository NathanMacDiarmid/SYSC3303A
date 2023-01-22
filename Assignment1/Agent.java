package Assignment1;

import java.util.Random;

public class Agent implements Runnable {
    private int firstIngredient;
    private int secondIngredient;
    private Table table;

    /**
     * Default constructor for Agent class
     * @param table the Table that is used as the middle man (Box class)
     */
    public Agent(Table table) {
        this.table = table;
    }

    @Override
    /**
     * The run method for the Agent class is inherited from the
     * Runnable interface. It runs the Thread when .start() is used
     */
    public void run() {
        while (true) {
            // Generates the two random ingredients to supply the table
            Random rand = new Random();
            firstIngredient = rand.nextInt((3 - 1) + 1) + 1;
            secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
            while (firstIngredient == secondIngredient) {
                secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
            }

            table.put(firstIngredient, secondIngredient);
            System.out.println("Agent just put the ingredient " + firstIngredient + " and second ingredient " + secondIngredient + " on the table");
        }
    }
}
