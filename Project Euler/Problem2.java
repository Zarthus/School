package nl.zarthus.euler;

import java.util.ArrayList;

public class Problem2 extends Euler
{
	/*
	 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
	 * By starting with 1 and 2, the first 10 terms will be:
	 * 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * 
	 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
	 * find the sum of the even-valued terms.
	 */

	public Problem2()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public void solve()
	{
		// MAX = 4 million as specified by assignment
		int sum = 0, a = 0, b = 1, tmp = 0;

		// Sum 	= total sum, and our answer for this assignment
		// A 	= the variable that holds the first number
		// B 	= the second variable that will always be 'a + b' on next iteration
		// tmp 	= temporary storage of A to calculate with.

		do
		{
			tmp = a + b;
			a = b;
			b = tmp;

			if (this.isEven(b))
			{
				sum = sum += b;
			}
		} while (b <= 4000000);

		System.out.println("Problem 2: " + sum);
	}

	public void solveTwo()
	{
		// MAX = 4 million as specified by assignment
		int sum = 0, a = 0, b = 1, tmp = 0;
		ArrayList<Integer> allEven = new ArrayList<Integer>(),
				allNums = new ArrayList<Integer>();

		// Sum 	= total sum, and our answer for this assignment
		// A 	= the variable that holds the first number
		// B 	= the second variable that will always be 'a + b' on next iteration
		// tmp 	= temporary storage of A to calculate with.

		do
		{
			tmp = a + b;
			a = b;
			b = tmp;
			allNums.add(b);

			if (this.isEven(b))
			{
				sum = sum += b;
				allEven.add(sum);
			}
		} while (b <= 4000000);

		System.out.println("Problem 2: " + sum);
		System.out.println("Problem 2 - Array (0) [all numbers]: " + allNums.toString());
		System.out.println("Problem 2 - Array (1) [new sum when even]: " + allEven.toString());
	}

	public boolean isEven(int value) // Check is a value is even by getting its remainder
	{
		return (value % 2) == 0;
	}
}
