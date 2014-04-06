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

public class Problem9 extends Euler {

	/*
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	 * which,
	 * 
	 * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 */

	public Problem9() {
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_SUBOPTIMAL;
	}

	@Override
	public void solve() {
		System.out.println("Problem 9: " + this.solveProblem());
	}

	public int solveProblem() {
		/*
		 * Loop through
		 */
		for (int a = 1; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				int c = 1000 - a - b;
				if (this.isPythagorean(a, b, c)) // a < b < c
				{
					return (a * b * c);
				}
			}
		}

		return 0;
	}

	public boolean isPythagorean(double a, double b, double c) {
		return ((a * a) + (b * b)) == (c * c);
	}
}
