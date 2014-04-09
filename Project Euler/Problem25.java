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
import java.math.BigInteger;

public class Problem25 extends Euler
{
	/*
		The Fibonacci sequence is defined by the recurrence relation:

		Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
		Hence the first 12 terms will be:

		F1 = 1
		F2 = 1
		F3 = 2
		F4 = 3
		F5 = 5
		F6 = 8
		F7 = 13
		F8 = 21
		F9 = 34
		F10 = 55
		F11 = 89
		F12 = 144
		The 12th term, F12, is the first term to contain three digits.

		What is the first term in the Fibonacci sequence to contain 1000 digits?
	 */

	public Problem25()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	private final int MAX_DIGITS = 1000;

	@Override
	public void solve()
	{
		BigInteger lowThreshold = BigInteger.TEN.pow(MAX_DIGITS - 1);
		BigInteger highThreshold = BigInteger.TEN.pow(MAX_DIGITS);

		BigInteger previous = BigInteger.ONE;
		BigInteger current = BigInteger.ZERO;

		int i = 0;

		while (true)
		{
			if (current.compareTo(lowThreshold) >= 0)
			{
				System.out.println("Problem 25: " + Integer.toString(i));
				break;
			}
			else if (current.compareTo(highThreshold) >= 0)
			{
				System.out.println("Problem 25: No viable solution was found");
				break;
			}

			BigInteger tmp = current.add(previous);
			previous = current;
			current = tmp;

			i++;
		}
	}


}
