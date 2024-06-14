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
