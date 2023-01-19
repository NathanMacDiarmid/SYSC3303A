package Assignment1;

import java.util.Random;

public class Agent implements Runnable {
    private int firstIngredient;
    private int secondIngredient;
    private Table table;

    public Agent(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            Random rand = new Random();
            firstIngredient = rand.nextInt((3 - 1) + 1) + 1;
            secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
            while (firstIngredient == secondIngredient) {
                secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
            }
            table.put(firstIngredient, secondIngredient);
            System.out.println("Agent just put the ingredients on the table:   " + firstIngredient + "   " + secondIngredient);
        }
    }
}
