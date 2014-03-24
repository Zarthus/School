package nl.zarthus.euler;

public class Problem21 extends Euler
{
	/*
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than
	 * n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b,
	 * then a and b are an amicable pair and each of a and b are called amicable
	 * numbers.
	 * 
	 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
	 * 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
	 * 2, 4, 71 and 142; so d(284) = 220.
	 * 
	 * Evaluate the sum of all the amicable numbers under 10000.
	 */

	public Problem21()
	{
		this.SOLVED = false;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public void solve()
	{
	}

	private int divSum(int q)
	{
		int sum = 0;

		for (int divider = 2; divider <= Math.sqrt(q); divider++)
		{
			if (this.isDividableBy(q, divider))
			{
				sum += divider;
			}
		}

		return sum;
	}

	private boolean isDividableBy(int dividable, int divider)
	{
		return (dividable % divider) == 0;
	}
}
