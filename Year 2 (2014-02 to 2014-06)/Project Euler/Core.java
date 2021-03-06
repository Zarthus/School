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

public class Core {
	public static void main(String[] args) {

		// Core.BenchmarkEuler(new Problem1()); // 124005 ns
		// Core.BenchmarkEuler(new Problem2()); // 56421 ns
		// new Problem2().solveTwo(); // Not measured
		// Core.BenchmarkEuler(new Problem3()); // 302 ns | unsolved
		// Core.BenchmarkEuler(new Problem4()); // 19 ms
		// Core.BenchmarkEuler(new Problem5()); // 77 ms | not optimal
		// Core.BenchmarkEuler(new Problem6()); // 334904 ns
		// Core.BenchmarkEuler(new Problem7()); // 19 ms
		// Core.BenchmarkEuler(new Problem8()); // 1 ms (1714043ns)
		// Core.BenchmarkEuler(new Problem9()); // 17 ms
		// Core.BenchmarkEuler(new Problem10()); // NOT YET MADE
		// Core.BenchmarkEuler(new Problem11()); // 1 ms
		// Core.BenchmarkEuler(new Problem12()); // NYM
		// Core.BenchmarkEuler(new Problem12()); // NOT YET MADE
		// Core.BenchmarkEuler(new Problem13()); // 6 ms
		Core.BenchmarkEuler(new Problem17()); // 11 ms
		// Core.BenchmarkEuler(new Problem18()); // 1 ms
		// Core.BenchmarkEuler(new Problem25()); // 11 ms
		// Core.BenchmarkEuler(new Problem31()); // 269434 nano seconds | 1 ms
		// Core.BenchmarkEuler(new Problem67()); // 1 ms
	}

	public static void BenchmarkAfter(long now, long after) {
		System.out.println("\nFinished solving problem.");
		System.out.println("Execution time:\n	" + (after - now) + " nano seconds\nor	" + ((after / 1000000) - (now / 1000000)) + " milli seconds");
		System.out.println("===========================================\n");
	}


	public static void BenchmarkBefore() {
		System.out.println("===========================================");
		System.out.println("Creating new problem and executing it.\n");
	}

	public static void BenchmarkEuler(Euler Problem) // Just a function which records time taken
	{ // to solve the problem.
		Core.BenchmarkBefore();

		long now = System.nanoTime();

		Problem.solve();

		long after = System.nanoTime();

		Problem.printSolvedString();

		Core.BenchmarkAfter(now, after);
	}

	public static void BenchmarkEuler(Euler Problem, int solveParam) // Just a function which records time taken
	{ // to solve the problem.
		Core.BenchmarkBefore();

		long now = System.nanoTime();

		Problem.solve(solveParam);

		long after = System.nanoTime();

		Problem.printSolvedString();

		Core.BenchmarkAfter(now, after);
	}

	// Exactly like one benchmark. Just makes it possible to benchmark it more
	// than once.
	public static void BenchmarkEulerAmount(Euler Problem, int amount) {
		System.out.println("===========================================");
		System.out.println("Creating new problem and executing it " + amount + " times\n");

		long now = System.nanoTime();

		for (int i = 0; i < amount; i++) {
			Problem.solve();
		}

		long after = System.nanoTime();

		System.out.println("\nFinished solving problem " + amount + " times.");
		System.out.println("Execution time:\n	" + (after - now) + " nano seconds\nor	" + ((after / 1000000) - (now / 1000000)) + " milli seconds");
		System.out.println("===========================================\n");
	}

}
