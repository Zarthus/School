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


public class Euler {
	public static final int SOLUTION_OPTIMAL = 1;
	public static final int SOLUTION_SUBOPTIMAL = 2;
	public static final int SOLUTION_MAYBE = 3;
	public int SOLUTION_STATE = Euler.SOLUTION_MAYBE;
	public static final int SOLUTION_INEFFICIENT = 4;
	public static final int SOLUTION_BRUTEFORCED = 5;
	public boolean SOLVED = false;

	public void solve() {
		System.out.println("Still using default Euler method solve()");
	}

	public void solve(int param) {
		System.out.println("Calling solve() on problem that does not support parameters.");
	}

	public boolean getSolved() {
		return this.SOLVED;
	}

	public void printSolvedString() {
		System.out.println("This problem is " + (this.SOLVED ? "" : "not yet ") + "solved.");
		if (this.SOLVED) {
			System.out.println(this.getSolutionStateString(this.SOLUTION_STATE));
		}
	}

	private String getSolutionStateString(int SolutionState) {
		switch (SolutionState) {
			case Euler.SOLUTION_INEFFICIENT:
				return "!! This solution is inefficient and could be improved";
			case Euler.SOLUTION_SUBOPTIMAL:
				return "** This solution is sub optimal";
			case Euler.SOLUTION_OPTIMAL:
				return "   This solution is marked as optimal and will not be improved upon by its submitter";
			case Euler.SOLUTION_MAYBE:
				return "?? The solution's state is undetermined";
			case Euler.SOLUTION_BRUTEFORCED:
				return "!! This solution attempts to bruteforce, which is more than likely inefficient.";
		}
		return null;
	}
}

