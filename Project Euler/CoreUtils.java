package nl.zarthus.euler;

public class CoreUtils
{
	/*
	 * This is a class that is not directly used, but instead copy pasted to the
	 * problem's class itself when needed
	 * 
	 * It serves the purpose of a collection of handy functions when working
	 * with a Project Euler Problem
	 * 
	 * Contains the following methods:
	 * 
	 * - isPrime - check if a number is a prime number.
	 * 
	 * - isPythagorean - check if a number is a Pytagorean number following this
	 * equation: (a*a + b*b == c*c)
	 */

	public boolean isPrime(long n)
	{
		if (n < 2)
		{
			return false;
		}
		if ((n == 2) || (n == 3))
		{
			return true;
		}
		if (((n % 2) == 0) || ((n % 3) == 0))
		{
			return false;
		}
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6)
		{
			if (((n % (i - 1)) == 0) || ((n % (i + 1)) == 0))
			{
				return false;
			}
		}
		return true;
	}

	public boolean isPythagorean(double a, double b, double c)
	{
		return ((a * a) + (b * b)) == (c * c);
	}

}
