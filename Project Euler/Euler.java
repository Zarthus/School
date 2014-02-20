package nl.zarthus.euler;


public class Euler
{
	public static final int SOLUTION_OPTIMAL = 1;
	public static final int SOLUTION_SUBOPTIMAL = 2;
	public static final int SOLUTION_MAYBE = 3;
	public static final int SOLUTION_INEFFICIENT = 4;
	public static final int SOLUTION_BRUTEFORCED = 5;

	public boolean SOLVED = false;
	public int SOLUTION_STATE = Euler.SOLUTION_MAYBE;

	public void solve()
	{
		System.out.println("Still using default Euler method solve()");
	}

	public void solve(int param)
	{
		System.out.println("Calling solve() on problem that does not support parameters.");
	}

	public boolean getSolved()
	{
		return this.SOLVED;
	}

	public void printSolvedString()
	{
		System.out.println("This problem is " + (this.SOLVED ? "" : "not yet ") + "solved.");
		if (this.SOLVED)
		{
			System.out
			.println(this.getSolutionStateString(this.SOLUTION_STATE));
		}
	}

	private String getSolutionStateString(int SolutionState)
	{
		switch (SolutionState)
		{
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

