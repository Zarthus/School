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

public class Problem11 extends Euler {
	/*
	 * In the 20�20 grid below, four numbers along a diagonal line have been
	 * marked in red.
	 * 
	 * @see aGrid
	 * 
	 * The product of these numbers is 26 � 63 � 78 � 14 = 1788696.
	 * 
	 * What is the greatest product of four adjacent numbers in the same
	 * direction (up, down, left, right, or diagonally) in the 20�20 grid?
	 */

	// As it turns out, Eclipse's formatter doesn't know how to do jack shit :(
	public final int[][] aGrid = {
			{8, 2, 22, 97, 38, 15, 00, 40, 00, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8}, {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 00}, {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65}, {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 2, 36, 91}, {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80}, {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50}, {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70}, {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21}, {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72}, {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95}, {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92}, {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57}, {86, 56, 00, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58}, {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40}, {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66}, {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69}, {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36}, {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16}, {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54}, {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}
	};

	public Problem11() {
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public void solve() {
		int iMax = - 1;

		// Math.max gets the highest of two provided values, which basically is
		// a faster
		// "int x = 2, y = 1;
		// iMax = (x > y ? x : y);"
		//
		// We're not constantly resetting the variable, just making sure it is
		// the highest of two values
		iMax = Math.max(this.getMaxProduct(1, 0), iMax);
		iMax = Math.max(this.getMaxProduct(0, 1), iMax);
		iMax = Math.max(this.getMaxProduct(1, 1), iMax);
		iMax = Math.max(this.getMaxProduct(1, - 1), iMax);
		System.out.println("Problem 11: " + iMax); // Completes in 1ms
	}

	public int getMaxProduct(int a, int b) {
		int iMax = - 1;
		int iGridLen = this.aGrid.length;
		for (int y = 0; y < iGridLen; y++) {
			for (int x = 0; x < this.aGrid[y].length; x++) {
				iMax = Math.max(this.getProductOf(x, y, a, b, 4), iMax);
			}
		}
		return iMax;
	}

	public int getProductOf(int x, int y, int x2, int y2, int n) {
		// if it is out of bounds, we clearly cannot continue.
		if (this.OutOfBounds(x + ((n - 1) * x2), y + ((n - 1) * y2))) {
			return - 1;
		}

		// Select and multiply iProduct by grid[y][x]
		int iProduct = 1;
		for (int i = 0; i < n; i++, x += x2, y += y2) {
			iProduct *= this.aGrid[y][x];
		}
		return iProduct;
	}

	public boolean OutOfBounds(int x, int y) {
		// We check if we're accessing an array value that is out of bounds.
		// In essence and in this example, it simply means we're not accessing
		// array values past 19 (20) or below 0.

		// System.out.println(this.aGrid.length + "|> " + x + "|" + y);

		// Return idea one: Doesn't check for array[<num>] value to be greater
		// than <x>, assuming the array is always a square both values will be
		// the same.

		return (((y <= 0) || (x <= 0)) || ((y > (this.aGrid.length - 4)) || (x > (this.aGrid[y].length - 4))));

		// Return idea two: might work with arrays that aren't squares (such as
		// `int[25][32]`, but not three dimensional arrays)
		// return (((y <= 0) || (x <= 0)) || ((y >= this.aGrid.length) || (x >=
		// this.aGrid.length)) || ((x >= this.aGrid[y].length) || (y >=
		// this.aGrid[y].length)));

		// Return idea three: try { } catch { } AIOOB exceptions.
		// try {
		// 	this.aGrid[y];
		//	this.aGrid[y][x];
		// }
		// catch (ArrayIndexOutOfBoundsException e)
		// {
		//		return false;
		// }
		// return true;
	}
}
