package nl.zarthus.euler;

public class Core
{
	public static void main(String[] args)
	{
		BenchmarkEuler(new Problem1());
		BenchmarkEuler(new Problem2());
		BenchmarkEuler(new Problem3());
		BenchmarkEuler(new Problem4());
	}

	public static void BenchmarkBefore()
	{
		System.out.println("===========================================");
		System.out.println("Creating new problem and executing it.\n");
	}

	public static void BenchmarkAfter(long now, long after)
	{
		System.out.println("\nFinished solving problem.");
		System.out.println("Execution time:\n	" + (after - now) + " nano seconds\nor	" + ((after / 1000000) - (now / 1000000)) + " milli seconds");
		System.out.println("===========================================\n");
	}

	public static void BenchmarkEuler(Euler Problem) // Just a function which records time taken
	{ // to solve the problem.
		BenchmarkBefore();

		long now = System.nanoTime();

		Problem.solve();

		long after = System.nanoTime();

		Problem.printSolvedString();

		BenchmarkAfter(now, after);
	}

	public static void BenchmarkEuler(Euler Problem, int solveParam) // Just a function which records time taken
	{ // to solve the problem.
		BenchmarkBefore();

		long now = System.nanoTime();

		Problem.solve(solveParam);

		long after = System.nanoTime();

		Problem.printSolvedString();

		BenchmarkAfter(now, after);
	}
}
