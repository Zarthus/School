package nl.zarthus.euler;

public class Problem5 extends Euler
{
	/*
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 */
	
	public Problem5()
	{
		this.SOLVED = true;
		this.OPTIMAL_SOLUTION = false;
	}
	
	@Override
	public void solve()
	{
		int i = 20;
		
		// Although not really flexable, I wasn't sure how to do it otherwise.
		// RIP Execution Speed ;_;
		
		// Evenly dividable by 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		// 13, 14, 15, 16, 17, 18, 19, and 20
		while (((i % 2) != 0) || ((i % 3) != 0) || ((i % 4) != 0) || ((i % 5) != 0) || ((i % 6) != 0) || ((i % 7) != 0) || ((i % 8) != 0) || ((i % 9) != 0) ||
				((i % 10) != 0) || ((i % 11) != 0) || ((i % 12) != 0) || ((i % 13) != 0) || ((i % 14) != 0) || ((i % 15) != 0) || ((i % 16) != 0)
				|| ((i % 17) != 0) || ((i % 18) != 0) || ((i % 19) != 0) || ((i % 20) != 0))
		{
			i += 20;
		}
		
		System.out.println("Problem 5: " + i);
	}
}