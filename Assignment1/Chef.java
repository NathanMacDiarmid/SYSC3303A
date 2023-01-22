package Assignment1;

import java.util.ArrayList;

public class Chef implements Runnable {
    private int ingredient;
    private Table table;

    /**
     * Default constructor for Chef
     * @param table the Table that is used as the middle man (Box class)
     * @param ingredient the ingredient that the Chef supplies to finish the sandwhich
     */
    public Chef(Table table, int ingredient) {
        this.table = table;
        this.ingredient = ingredient;
    }

    @Override
    /**
     * The run method for the Chef class is inherited from the
     * Runnable interface. It runs the Thread when .start() is used
     */
    public void run() {
        while (true) {
            ArrayList<Integer> ingredients = table.get(this.ingredient);
            System.out.println("I made a sandwhich with given ingredients: " + ingredients + " and my " + this.ingredient);
        }
    }
}
