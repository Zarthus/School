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

public class Problem17 extends Euler
{

	/*
		if the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

		If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

		NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
	 */

	public Problem17()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	public String[] ONES = {
		"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};

	public String[] TEENS = {
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	public String[] TENS = {
		"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	@Override
	public void solve()
	{
		int iAnswer = 0;
		for (int i = 1; i <= 1000; i++) // 1000 numbers
		{
			iAnswer += getNumber(i).length();
		}

		System.out.println("Problem 17: " + Integer.toString(iAnswer));
	}

	private String getNumber(int number)
	{
		if (number >= 100000) // 100.000
		{
			System.out.println("Problem 17: Invalid input in 'getNumber(" + number + ")' ");
			System.exit(-1);
		}

		if (number < 100)
		{
			return getTens(number);
		}
		else
		{
			String sReturn = "";
			if (number >= 1000)
			{
				sReturn += getTens(number / 1000) + "thousand";
			}
			if (number / 100 % 10 != 0)
			{
				sReturn += ONES[number / 100 % 10] + "hundred";
			}

			sReturn += (number % 100 != 0 ? "and" + getTens(number % 100) : "");

			return sReturn;
		}
	}

	private String getTens(int tens)
	{
		if (tens < 10)
		{
			return ONES[tens];
		}
		if (tens < 20)
		{
			return TEENS[tens - 10]; // To make sure we don't exceed bounds.
		}

		return TENS[tens / 10 - 2] + (tens % 10 != 0 ? ONES[tens % 10] : "");
	}
}
