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

public class Problem7 extends Euler {
	public Problem7() {
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public void solve() {

		int primesFound = 1;
		long i = 1;
		while (primesFound < 10001) {
			i += 2;

			if (this.isPrime(i)) {
				primesFound++;
			}
		}

		System.out.println("Problem 7: " + i + " is the 10,001th prime number");
	}

	private boolean isPrime(long primeCheck) {
		if (this.isEven(primeCheck) || (primeCheck == 2)) {
			return false;
		}

		int sqrt = (int) Math.sqrt(primeCheck);
		for (int i = 2; i <= sqrt; i++) {
			if ((primeCheck % i) == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isEven(long evenCheck) {
		return (evenCheck % 2) == 0;
	}
}