#include <stdio.h>
#include <math.h> // Include the sqrt() function
#include <stdbool.h> // Allows the bool keyword

bool ispent(long i)
{
        double ispent = (sqrt(1 + 24 * i) + 1) / 6;
        return ispent == (int) ispent;
}

int main(void)
{
	int i = 143; // Example shows Hex(143) is lowest.
	long answer = 0; // Store answer

	while (1)
	{
			i++;
			answer = i * (2 * i - 1); //

			if (ispent(answer))
			{       //
					printf("Problem 45 - Answer: %d -> %lu\n", i, answer);
					break;
			}
	}
	return 0;
}

