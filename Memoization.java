import java.util.*;
import java.util.stream.*;

public class Memoization {

    public static void main(String [] args) {
        System.out.printf("Hello Coin Change Memoization Solution #1  %n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java Memoization <amount>  %n");
            System.out.printf("    find minimum number of coins to make change for the given amount  %n");
            return;
        }


        if (args == null || args.length == 0) { // check for args
            System.out.printf("The amount is necessary  %n");
            return;
        }

        String input = args[0];
        boolean hasValidNumber = input.matches("^[1-9]+$");
        if (!hasValidNumber) {
            System.out.printf("Number must be digits between 1 and 9  %n");
            return;
        }

        int amount = Integer.valueOf(input);

        Memoization memoization = new Memoization(amount);

        int result = memoization.solution();

        System.out.printf("The result = %d  %n", result);
    }

    private int amount;
    private int [] coins = new int [] {1, 2, 4};
    private Map<Integer, Integer> memo;

    public Memoization(int amount) {
        this.amount = amount;
        this.memo = new HashMap<>();
    }

    public int solution() {
        System.out.printf("%nfinding the solution for amount = %d  %n", this.amount);

        // Top Down Dynamic Programming (Memoization)
        // Time: O(Coins * Amount)
        // Space: O(Amount)

        // The memo map will remember coins needed for intermediate amounts.
        // This recursively records down to the base cases.
        // The result is bubbled up as recursive calls pop off the call stack.

        // Included a sort of the coins, in case solution is refactored to pass in coin list.
        Arrays.sort(coins);

        int result = getMinimumCoins(amount);

        // Final decision on what to return.
        // If the number of coins for the original amount in result
        // is less than Integer.MAX_VALUE,
        // then return the result.
        // Otherwise, return -1;
        if (result < Integer.MAX_VALUE) {
            System.out.printf("%n%nThe dynamically programmed number of coins for amount %d is %d  %n", amount, result);
            return result;
        } else {
            return -1;
        }
    }

    private int getMinimumCoins(int amount) {


        // This method is the recursive equivalent of the for loop
        // in the tabulation solution.
        // It is top-down since each coin face value is subtracted
        // from the amount until the stop condition is met.

        System.out.printf("%n%nNow discovering coin change for intermediate amount %d  %n", amount);

        if (memo.containsKey(amount)) {
            System.out.printf("Intermediate amount %d in memo  %n", amount);
            return memo.get(amount);
        }

        int minimumNumberOfCoins = Integer.MAX_VALUE;

        int coinIndex = 0;

        // for every coin
        while(coinIndex < coins.length) {

            // Find the remaining amount of the difference
            // between the intermediate amount and this coin
            int coin = coins[coinIndex];
            int remainingAmountDifference = amount - coin;

            System.out.printf("%nNow processing coin value of %d  %n", coin);
            System.out.printf("analyze this intermediate amount minus this coin value to get the remaining amount difference  %n");
            System.out.printf("values %d - %d = %d  %n", amount, coin, remainingAmountDifference);

            // If this coin pushed the value of remaining amount difference below zero,
            // then this was one coin too many.
            // The previous coin was the biggest coin value to make change,
            // for this intermediate amount.
            if (remainingAmountDifference < 0) {
                System.out.printf("a negative remaining amount difference is the stop condition of coin processing  %n");
                break;
            }
            // Otherwise, make note of the minimum number of coins
            // for this remaining amount difference plus one more count for this coin.
            System.out.printf("Record updated minimum number of coins  %n");
            System.out.printf("Before, the minimum number of coins is %d  %n", minimumNumberOfCoins);
            System.out.printf("The dynamic programming value is stored according to the remaining amount difference  %n");
            System.out.printf("The remaining amount difference is %d  %n", remainingAmountDifference);
            System.out.printf("The value of 1 is added to this dp value to account for this coin being processed  %n");
            System.out.printf("Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  %n");

            minimumNumberOfCoins = Math.min(minimumNumberOfCoins, 1 + getMinimumCoins(remainingAmountDifference));

            System.out.printf("After, the minimum number of coins is %d  %n", minimumNumberOfCoins);

            coinIndex++;
        }


        // If the minimum number of coins is MAX_VALUE,
        // like when the amount is zero and remaining amount difference is less than zero,
        // then return no coins = 0.
        if (minimumNumberOfCoins == Integer.MAX_VALUE) {
            System.out.printf("Stop condition  %n");
            System.out.printf("No minimum number of coins found for amount %d  %n", amount);
            System.out.printf("found minimum number of coins to be MAX_VALUE  %n");
            System.out.printf("Return 0 minimum number of coins, do not store in memo  %n");
            return 0; // no coins for zero amount; stop condition for recursion
        }
        // Otherwise, store the minimumNumberOfCoins by the recursive amount
        System.out.printf("Store in memo the dynamically programmed number of coins for intermediate amount %d as %d  %n", amount, minimumNumberOfCoins);

        memo.put(amount, minimumNumberOfCoins);

        return minimumNumberOfCoins;
    }

}
