package Assignment1;

import java.util.ArrayList;

public class Chef implements Runnable {
    private int ingredient;
    private Table table;

    public Chef(Table table, int ingredient) {
        this.table = table;
        this.ingredient = ingredient;
    }

    @Override
    public void run() {
        while (true) {
            ArrayList<Integer> ingredients = table.get(this.ingredient);
            System.out.println("I made a sandwhich with " + ingredients + " and " + this.ingredient);
        }
    }
}
