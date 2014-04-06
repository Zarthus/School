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

public class CoreUtils {
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

	public boolean isPrime(long n) {
		if (n < 2) {
			return false;
		}
		if ((n == 2) || (n == 3)) {
			return true;
		}
		if (((n % 2) == 0) || ((n % 3) == 0)) {
			return false;
		}
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (((n % (i - 1)) == 0) || ((n % (i + 1)) == 0)) {
				return false;
			}
		}
		return true;
	}

	public boolean isPythagorean(double a, double b, double c) {
		return ((a * a) + (b * b)) == (c * c);
	}

	public boolean isEven(int even) {
		return (even % 2) == 0;
	}

	public boolean isDividableBy(int dividable, int divider) {
		return (dividable % divider) == 0;
	}
}
