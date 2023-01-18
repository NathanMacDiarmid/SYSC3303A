package Assignment1;

import java.util.Random;

public class Agent {

    public static void main (String[] args) {
        BreadChef breadChef = new BreadChef();
        JamChef jamChef = new JamChef();
        PeanutButterChef peanutButterChef = new PeanutButterChef();
        Random rand = new Random();
        int firstIngredient = rand.nextInt((3 - 1) + 1) + 1;
        int secondIngredient = 0;
        boolean notTheSame = true;

        // initializes the first two random numbers
        while (notTheSame) {
            secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
            if (!(firstIngredient == secondIngredient)) {
                notTheSame = false;
            }
        }
        for (int i = 1; i <= 20; i++) {
            breadChef.run();
            jamChef.run();
            peanutButterChef.run();
        }
    }
    
}
