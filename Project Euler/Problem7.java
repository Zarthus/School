package nl.zarthus.euler;

public class Problem7 extends Euler
{
	public Problem7()
	{
		this.SOLVED = true;
	}
	
	@Override
	public void solve()
	{
		
		int primesFound = 1;
		long i = 1;
		while(primesFound < 10001)
		{
			i += 2;
			
			if (this.isPrime(i))
			{
				primesFound++;
			}
		}
		
		System.out.println("Problem 7: " + i + " is the 10,001th prime number");
	}
	
	private boolean isPrime(long primeCheck)
	{
		if (this.isEven(primeCheck) || (primeCheck == 2))
			return false;
		
		int sqrt = (int) Math.sqrt(primeCheck);
		for (int i = 2; i <= sqrt; i++)
		{
			if ((primeCheck % i) == 0)
				return false;
		}
		return true;
	}
	
	private boolean isEven(long evenCheck)
	{
		return (evenCheck % 2) == 0;
	}
}