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

public class Problem5 extends Euler {
	/*
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 */

	public Problem5() {
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_INEFFICIENT;
	}

	@Override
	public void solve() {
		int i = 20;

		// Although not really flexable, I wasn't sure how to do it otherwise.
		// RIP Execution Speed ;_;

		// Evenly dividable by 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
		// 13, 14, 15, 16, 17, 18, 19, and 20
		while (((i % 2) != 0) || ((i % 3) != 0) || ((i % 4) != 0) || ((i % 5) != 0) || ((i % 6) != 0) || ((i % 7) != 0) || ((i % 8) != 0) || ((i % 9) != 0) ||
				((i % 10) != 0) || ((i % 11) != 0) || ((i % 12) != 0) || ((i % 13) != 0) || ((i % 14) != 0) || ((i % 15) != 0) || ((i % 16) != 0) || ((i % 17) != 0) || ((i % 18) != 0) || ((i % 19) != 0) || ((i % 20) != 0)) {
			i += 20;
		}

		System.out.println("Problem 5: " + i);
	}
}
