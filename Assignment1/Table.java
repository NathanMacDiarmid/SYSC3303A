package Assignment1;

import java.util.ArrayList;

public class Table {
    private boolean empty = true;
    private ArrayList<Integer> ingredients = new ArrayList<>();
    private int totalSandwhiches = 0;

    public synchronized ArrayList<Integer> get(int ingredient) {
        while (empty || isRightIngredient(ingredient)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ArrayList<Integer> buffer = new ArrayList<>();
        buffer.addAll(ingredients);
        ingredients.clear();
        empty = true;
        totalSandwhiches++;
        System.out.println(totalSandwhiches);
        if (totalSandwhiches >= 20) {
            System.exit(1);
        }
        notifyAll();
        return buffer;
    }

    public synchronized void put(int firstIngredient, int secondIngredient) {
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.ingredients.add(firstIngredient);
        this.ingredients.add(secondIngredient);
        empty = false;
        notifyAll();
    }

    public boolean isRightIngredient(int ingredient) {
        if (this.ingredients.get(0) == ingredient || this.ingredients.get(1) == ingredient) {
            return true;
        }
        return false;
    }
}
