package nl.zarthus.euler;

public class Problem3 extends Euler
{
	/*
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 *
	 * What is the largest prime factor of the number 600851475143 ?
	 */
	
	public Problem3()
	{
		this.SOLVED = false;
	}
	
	public boolean isPrime(long num)
	{
		if ((num & 1) == 0) return false; // Dividable by 2?
		
		for (long i = 2; i <= num; i++)
		{
			if ((num % i) == 0) return false;
		}
		
		return true;
	}
	
	@Override
	public void solve()
	{
	}
}
