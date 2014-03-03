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

	public boolean isPrime(long num)
	{
		if ((num & 1) == 0)
		{
			return false; // Dividable by 2?
		}

		for (long i = 2; i <= num; i++)
		{
			if ((num % i) == 0)
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
