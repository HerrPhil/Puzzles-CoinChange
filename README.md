# Puzzles-CoinChange

Find the minimum number of coins needed to total to a given amount.

## Background

I plucked this lesson task from the videos of Gregg Hogg.

It originates from a Google interview question.

The solution comes from LeetCode.

LeetCode is a programming interview practice tool.

The LeetCode solution demostrates two techniques of dynamic programming.

I am still figuring out dynamic programming. It can be non-intuitive.

### Dynamic Programming

See this Baeldung [article](https://www.baeldung.com/cs/tabulation-vs-memoization#:~:text=Tabulation%20is%20a%20bottom%2Dup,problems%20are%20the%20base%20cases.) here.

Dynamic Programming (DP) is an optimization paradigm that finds the optimal solution to the initial problem by
solving its sub-problems and combining their solutions, usually in polynomial time. In doing so, DP makes use of
[Bellman's Principle of Optimality](https://en.wikipedia.org/wiki/Bellman_equation), which states as follows:

> A sub-solution of the entire problem's optimal solution is the optimal solution to the corresponding sub-problem.

So, DP first divides the problem so that the optimal solution of the whole problem is a combination of the optimal
solutions to its sub-problems. But the same applies to sub-problems: their optimal solutions are also
combinations of their sub-problems' optimal solutions. This division continues until we reach base cases.

#### Tabulation

Tabulation is a bottom-up method for solving DP problems. It starts from the base cases and finds the optimal
solutions to the problems whose immediate sub-problems are the base cases. Then, it goes one level up and
combines the solutions it previously obtained to construct the optimal solutions to more complex problems.

I will trace through the tabulation solution first.

It is not gelling in my mind how this works.

I am a visual learner; I need to see the DP values build up to understand what is happening.


Here is the logger output of the solution.

I observe now that at every intermediate amount, the solution checks for a previous solution.

The previous solution will be based on the face value of the coin currently being utilized.

That coin face value determines what the remaining amount difference will be.


>Hello Coin Change Tabulation Solution #1

finding the solution for amount = 5  


Now discovering coin change for intermediate amount 1  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 1 - 1 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The dynamic programming value of 0 is stored at index 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 1  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 1 - 2 = -1  
a negative remaining amount difference is the stop condition of coin processing  
The dynamically programmed number of coins for intermediate amount 1 is 1  


Now discovering coin change for intermediate amount 2  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 1 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The dynamic programming value of 1 is stored at index 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 2 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The dynamic programming value of 0 is stored at index 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 1  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 4 = -2  
a negative remaining amount difference is the stop condition of coin processing  
The dynamically programmed number of coins for intermediate amount 2 is 1  


Now discovering coin change for intermediate amount 3  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 1 = 2  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 2  
The dynamic programming value of 1 is stored at index 2  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 2 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The dynamic programming value of 1 is stored at index 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 4 = -1  
a negative remaining amount difference is the stop condition of coin processing  
The dynamically programmed number of coins for intermediate amount 3 is 2  


Now discovering coin change for intermediate amount 4  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 1 = 3  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 3  
The dynamic programming value of 2 is stored at index 3  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 3  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 2 = 2  
Record updated minimum number of coins  
Before, the minimum number of coins is 3  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 2  
The dynamic programming value of 1 is stored at index 2  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 4 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The dynamic programming value of 0 is stored at index 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 1  
The dynamically programmed number of coins for intermediate amount 4 is 1  


Now discovering coin change for intermediate amount 5

Now processing coin value of 1
analyze this intermediate amount minus this coin value to get the remaining amount difference
values 5 - 1 = 4
Record updated minimum number of coins
Before, the minimum number of coins is 2147483647
The dynamic programming value is stored according to the remaining amount difference
The remaining amount difference is 4
The dynamic programming value of 1 is stored at index 4
The value of 1 is added to this dp value to account for this coin being processed
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins
After, the minimum number of coins is 2

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 5 - 2 = 3  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 3  
The dynamic programming value of 2 is stored at index 3  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 5 - 4 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The dynamic programming value of 1 is stored at index 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  
After, the minimum number of coins is 2  
The dynamically programmed number of coins for intermediate amount 5 is 2  


The dynamically programmed number of coins for amount 5 is 2  
The result = 2  


Next, I will work on the memoization solution and comprehend its techniques.

#### Memoization

There is a way to have the efficiency of tabulation and keep the elegance
and understandability of recursion. It is memoization.

The idea behind it is as follows. First, we write the recursive algorithm as usual.
Then, we enrich it with a memory structure where we store the solutions
to sub-problems we solve. If we re-encounter the same sub-problem during
the execution of the recursive algorithm, we don't recalculate its solution.
Instead, we read it from memory.

This way, we avoid repeated computation and reduce the time complexity
to the number of different sub-problems. We do so at the expense of the
space complexity but don't use more memory than the corresponding
tabulation algorithm.

The recursive code is fairly intutive.

The logging is helpful, but a bit non-intuitive if you lose track of the recursion
level the algorithm is in.

> java -cp . Memoization 5  
Hello Coin Change Memoization Solution #1  

finding the solution for amount = 5  


Now discovering coin change for intermediate amount 5  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 5 - 1 = 4  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 4  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 4  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 1 = 3  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 3  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 3  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 1 = 2  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 2  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 2  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 1 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 1  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 1 - 1 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2147483647  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 0  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 0 - 1 = -1  
a negative remaining amount difference is the stop condition of coin processing  
Stop condition  
No minimum number of coins found for amount 0  
found minimum number of coins to be MAX_VALUE  
Return 0 minimum number of coins, do not store in memo  
After, the minimum number of coins is 1  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 1 - 2 = -1  
a negative remaining amount difference is the stop condition of coin processing  
Store in memo the dynamically programmed number of coins for intermediate amount 1 as 1  
After, the minimum number of coins is 2  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 2 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 0  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 0 - 1 = -1  
a negative remaining amount difference is the stop condition of coin processing  
Stop condition  
No minimum number of coins found for amount 0  
found minimum number of coins to be MAX_VALUE  
Return 0 minimum number of coins, do not store in memo  
After, the minimum number of coins is 1  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 2 - 4 = -2  
a negative remaining amount difference is the stop condition of coin processing  
Store in memo the dynamically programmed number of coins for intermediate amount 2 as 1  
After, the minimum number of coins is 2  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 2 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 1  
Intermediate amount 1 in memo  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 3 - 4 = -1  
a negative remaining amount difference is the stop condition of coin processing  
Store in memo the dynamically programmed number of coins for intermediate amount 3 as 2  
After, the minimum number of coins is 3  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 2 = 2  
Record updated minimum number of coins  
Before, the minimum number of coins is 3  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 2  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 2  
Intermediate amount 2 in memo  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 4 - 4 = 0  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 0  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 0  

Now processing coin value of 1  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 0 - 1 = -1  
a negative remaining amount difference is the stop condition of coin processing  
Stop condition  
No minimum number of coins found for amount 0  
found minimum number of coins to be MAX_VALUE  
Return 0 minimum number of coins, do not store in memo  
After, the minimum number of coins is 1  
Store in memo the dynamically programmed number of coins for intermediate amount 4 as 1  
After, the minimum number of coins is 2  

Now processing coin value of 2  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 5 - 2 = 3  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 3  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 3  
Intermediate amount 3 in memo  
After, the minimum number of coins is 2  

Now processing coin value of 4  
analyze this intermediate amount minus this coin value to get the remaining amount difference  
values 5 - 4 = 1  
Record updated minimum number of coins  
Before, the minimum number of coins is 2  
The dynamic programming value is stored according to the remaining amount difference  
The remaining amount difference is 1  
The value of 1 is added to this dp value to account for this coin being processed  
Then this value is compared to the current minimum number of coins to find the updated minimum number of coins  


Now discovering coin change for intermediate amount 1  
Intermediate amount 1 in memo  
After, the minimum number of coins is 2  
Store in memo the dynamically programmed number of coins for intermediate amount 5 as 2  


The dynamically programmed number of coins for amount 5 is 2  
The result = 2  

