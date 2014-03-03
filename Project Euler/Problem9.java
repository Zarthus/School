package nl.zarthus.euler;

public class Problem9 extends Euler
{

	/*
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	 * which,
	 * 
	 * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 */

	public Problem9()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_SUBOPTIMAL;
	}

	@Override
	public void solve()
	{
		System.out.println("Problem 9: " + this.solveProblem());
	}

	public int solveProblem()
	{
		/*
		 * Loop through
		 */
		for (int a = 1; a < 1000; a++)
		{
			for (int b = a + 1; b < 1000; b++)
			{
				int c = 1000 - a - b;
				if (this.isPythagorean(a, b, c)) // a < b < c
				{
					return (a * b * c);
				}
			}
		}

		return 0;
	}

	public boolean isPythagorean(double a, double b, double c)
	{
		return ((a * a) + (b * b)) == (c * c);
	}
}
