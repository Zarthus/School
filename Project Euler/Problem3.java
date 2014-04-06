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

public class Problem3 extends Euler {
	/*
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 *
	 * What is the largest prime factor of the number 600851475143 ?
	 */

	public Problem3() {
		this.SOLVED = false;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	public boolean isPrime(long num) {
		if ((num & 1) == 0) {
			return false; // Dividable by 2?
		}

		for (long i = 2; i <= num; i++) {
			if ((num % i) == 0) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void solve() {
	}
}
