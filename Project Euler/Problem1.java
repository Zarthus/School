package nl.zarthus.euler;

public class Problem1 extends Euler
{
	/*
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */

	public Problem1()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public void solve()
	{
		int sum = 0; // Initialize the sum

		for (int i = 0; i < 1000; i++) // Loop through all values between zero and one thousand
		{
			if (i % 3 == 0 || i % 5 == 0) // If the remainder of the value i is zero for either 3 or 5, we
			{ // add the value to the sum;
				sum += i;
			}
		}
		System.out.println("Problem 1: " + sum);
	}
}
