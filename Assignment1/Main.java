package Assignment1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int firstIngredient;
        int secondIngredient;
        boolean notTheSame = true;

        for (int i = 1; i <= 20; i++) {
            firstIngredient = rand.nextInt((3 - 1) + 1) + 1;

            // initializes the first two random numbers
            while (notTheSame) {
                secondIngredient = rand.nextInt((3 - 1) + 1) + 1;
                if (!(firstIngredient == secondIngredient)) {
                    notTheSame = false;
                }
            }
            // this is where thread calling goes
        }
    }
}
