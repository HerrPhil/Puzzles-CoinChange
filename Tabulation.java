import java.util.*;
import java.util.stream.*;

public class Tabulation {

    public static void main(String [] args) {
        System.out.printf("Hello Coin Change Tabulation Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java Tabulation <amount>%n");
            System.out.printf("    find minimum number of coins to make change for the given amount%n");
            return;
        }


        if (args == null || args.length == 0) { // check for args
            System.out.printf("The amount is necessary%n");
            return;
        }

        String input = args[0];
        boolean hasValidNumber = input.matches("^[1-9]+$");
        if (!hasValidNumber) {
            System.out.printf("Number must be digits between 1 and 9%n");
            return;
        }

        int amount = Integer.valueOf(input);

        Tabulation tabulation = new Tabulation(amount);

        int result = tabulation.solution();

        System.out.printf("The result = %d%n", result);
    }

    private int amount;
    private int [] coins = new int [] {1, 2, 4};

    public Tabulation(int amount) {
        this.amount = amount;
    }

    public int solution() {
        System.out.printf("%nfinding the solution for amount = %d%n", this.amount);

        // Bottom Up Dynamic Programming (Tabulation)
        // Time: O(Coins * Amount)
        // Space: O(Amount)

        // The dp array will tabulate coins needed for intermediate amounts.
        // This tabulates towards the requested amount.
        // The array will default to values of zero; desired.
        // TODO: figure out why the size is amount + 1.
        // HUNCH: leave amount at index 0 defaulted to zero, like an identity property.
        // Zero coins needed to make change for zero amount.
        int [] dp = new int [amount + 1];

        // Included a sort of the coins, in case solution is refactored to pass in coin list.
        Arrays.sort(coins);

        // Like the python code, the integer value of amount + 1
        // is the integer number that will stop the sequence.
        for(int intermediateAmount = 1; intermediateAmount < amount + 1; intermediateAmount++) {

            int minimumNumberOfCoins = Integer.MAX_VALUE;

            // Local variables must be final or effectively final
            // when referenced from a Lambda expression.
            final int finalIntermediateAmount = intermediateAmount;
            // for every coin
            Arrays.stream(coins).forEach(coin -> {

                // Find the remaining amount of the difference
                // between the intermediate amount and this coin
                int remainingAmountDifference = finalIntermediateAmount - coin;

                System.out.printf("analyze this intermediate amount minus this coin value to get the remaining amount difference%n");
                System.out.printf("values %d - %d = %d%n", finalIntermediateAmount, coin, remainingAmountDifference);

            });

        }

        return -1;
    }

}
