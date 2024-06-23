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

            System.out.printf("%n%nNow discovering coin change for intermediate amount %d%n", intermediateAmount);

            int minimumNumberOfCoins = Integer.MAX_VALUE;

            int coinIndex = 0;
           
            // for every coin
            while(coinIndex < coins.length) {

                // Find the remaining amount of the difference
                // between the intermediate amount and this coin
                int coin = coins[coinIndex];
                int remainingAmountDifference = intermediateAmount - coin;

                System.out.printf("%nNow processing coin value of %d%n", coin);
                System.out.printf("analyze this intermediate amount minus this coin value to get the remaining amount difference%n");
                System.out.printf("values %d - %d = %d%n", intermediateAmount, coin, remainingAmountDifference);

                // If this coin pushed the value of remaining amount difference,
                // then this was one coin too many.
                // The previous coin was the biggest coin value to make change,
                // for this intermediate amount.
                if (remainingAmountDifference < 0) {
                    System.out.printf("a negative remaining amount difference is the stop condition of coin processing%n"); 
                    break;
                }

                // Otherwise, make note of the minimum number of coins
                // for this remaining amount difference plus one more count for this coin.
                System.out.printf("Record updated minimum number of coins%n");
                System.out.printf("Before, the minimum number of coins is %d%n", minimumNumberOfCoins);
                System.out.printf("The dynamic programming value is stored according to the remaining amount difference%n");
                System.out.printf("The remaining amount difference is %d%n", remainingAmountDifference);
                System.out.printf("The dynamic programming value of %d is stored at index %d%n", dp[remainingAmountDifference], remainingAmountDifference);
                System.out.printf("The value of 1 is added to this dp value to account for this coin being processed%n");
                System.out.printf("Then this value is compared to the current minimum number of coins to find the updated minimum number of coins%n");

                minimumNumberOfCoins = Math.min(minimumNumberOfCoins, dp[remainingAmountDifference] + 1);

                System.out.printf("After, the minimum number of coins is %d%n", minimumNumberOfCoins);

                coinIndex++;
            }

            // Now, store the minimumNumberOfCoins by the intermedidate amount
            System.out.printf("The dynamically programmed number of coins for intermediate amount %d is %d%n", intermediateAmount, minimumNumberOfCoins);
            dp[intermediateAmount] = minimumNumberOfCoins;

        }

        // Final decision on what to return.
        // If the number of coins for the original amount in dp
        // is less than Integer.MAX_VALUE,
        // then return the value at index, amount, of array dp.
        // Otherwise, return -1;
        if (dp[amount] < Integer.MAX_VALUE) {
            System.out.printf("%n%nThe dynamically programmed number of coins for amount %d is %d%n", amount, dp[amount]);
            return dp[amount];
        } else {
            return -1;
        }
    }

}
