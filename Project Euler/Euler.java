package nl.zarthus.euler;

public class Euler
{
	public boolean SOLVED = false;

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
	}
}
