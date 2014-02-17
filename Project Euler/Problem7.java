/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{

		int primesFound = 1;
		long i = 1;
		while(primesFound < 10001)
		{
			i+=2;

			if (isPrime(i))
			{
				primesFound++;
			}
		}

		System.out.println("Problem 7: " + i + " is the 10,001th prime number");
	}
	
	private static boolean isPrime(long primeCheck)
	{
		if (isEven(primeCheck) || primeCheck == 2)
			return false;
		
		int sqrt = (int) Math.sqrt(primeCheck);	
        for (int i = 2; i <= sqrt; i++)
        {
	        if (primeCheck % i == 0)
            	return false;
        }	 	
		return true;
	}
	
	private static boolean isEven(long evenCheck)
	{
		return (evenCheck % 2) == 0;	
	}
}