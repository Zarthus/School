package nl.zarthus.euler;


public class Problem31 extends Euler
{
	public Problem31()
	{
		this.SOLVED = true;
		this.SOLUTION_STATE = Euler.SOLUTION_OPTIMAL;
	}

	@Override
	public final void solve()
	{
		final int TARGET = 200;
		final int[] COIN_VALUES = { 1, 2, 5, 10, 20, 50, 100, 200 };
		final int COIN_LEN = COIN_VALUES.length;

		int[][] methods = new int[COIN_VALUES.length + 1][TARGET + 1];
		methods[0][0] = 1;

		for (int i = 0; i < COIN_LEN; i++)
		{
			for (int x = 0; x <= TARGET; x++)
			{
				methods[i + 1][x] = methods[i][x] 
					+ (x >= COIN_VALUES[i] 
							? methods[i + 1][x - COIN_VALUES[i]] 
							: 0);
			}
		}

		System.out.println("Problem 31: 2 GBP can be made in "
				+ methods[COIN_LEN][TARGET] + " ways");
	}
}
