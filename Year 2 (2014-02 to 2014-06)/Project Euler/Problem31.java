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


public class Problem31 extends Euler {
	public Problem31() {
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public final void solve() {
		final int TARGET = 200;
		final int[] COIN_VALUES = {1, 2, 5, 10, 20, 50, 100, 200};
		final int COIN_LEN = COIN_VALUES.length;

		int[][] methods = new int[COIN_VALUES.length + 1][TARGET + 1];
		methods[0][0] = 1;

		for (int i = 0; i < COIN_LEN; i++) {
			for (int x = 0; x <= TARGET; x++) {
				methods[i + 1][x] = methods[i][x] + (x >= COIN_VALUES[i] ? methods[i + 1][x - COIN_VALUES[i]] : 0);
			}
		}

		System.out.println("Problem 31: 2 GBP can be made in " + methods[COIN_LEN][TARGET] + " ways");
	}
}
