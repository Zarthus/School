/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Zarthus <zarthus@zarth.us>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package nl.zarthus.euler;

public class Problem4 extends Euler {
	/* A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 � 99.
	 *
	 * Find the largest palindrome made from the product of two 3-digit numbers.
     *
	 */

	public Problem4() {
		this.SOLVED = true;
	}

	public void solve() {
		int max = 0;

		// Start at 100, that is the lowest 3 digit number
		for (int i = 100; i < 1000; ++ i) {
			for (int num = i; num < 1000; ++ num) {
				int pal = i * num;

				// Check if pal is a palindrome, and if it exceeds our last max number
				if (isPalindrome(pal) && pal > max) {
					max = pal;
				}
			}
		}

		// Print out the solution
		System.out.println("Problem 4: " + max);
	}

	public int reverse(int num) {
		int num2 = 0;

		while (num != 0) {
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
