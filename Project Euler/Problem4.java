package nl.zarthus.euler;

public class Problem4 extends Euler
{
	/* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 *
	 * Find the largest palindrome made from the product of two 3-digit numbers.
     *
	 */
	
	public Problem4()
	{
		this.SOLVED = true;
	}
	
	public void solve()
	{
	    int max = 0;

	    // Start at 100, that is the lowest 3 digit number
	    for (int i = 100; i < 1000; ++i)
	    {
	        for (int num = i; num < 1000; ++num) 
	        {
	            int pal = i * num;
	            
	            // Check if pal is a palindrome, and if it exceeds our last max number
	            if (isPalindrome(pal) && pal > max) 
	            	max = pal;
	        }
	    }

        // Print out the solution
	    System.out.println("Problem 4: " + max);
	}
	
    public int reverse(int num) 
    {
    	int num2 = 0;

        while (num != 0) 
        {
        	// Reverse the number
        	int reverse = num % 10;
            num2 = (num2 * 10) + reverse;
            num /= 10;
        }
        return num2;
    }
 
	public boolean isPalindrome(int n) {
		return (n == reverse(n)) ? true : false;
	} 
}
