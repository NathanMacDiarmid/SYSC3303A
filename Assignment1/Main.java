package Assignment1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
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

        //BreadChef breadChef = new BreadChef(firstIngredient, secondIngredient);
        //JamChef jamChef = new JamChef();
        //PeanutButterChef peanutButterChef = new PeanutButterChef();

        for (int i = 1; i <= 15; i++) {
        }
    }
}
