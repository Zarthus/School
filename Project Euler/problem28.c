#include <stdio.h>

int main(int argc, char *argv[])
{

    long sum = 1;
    int itter;
    int MAX_SIZE; // User can input a value here if desired; 1001 default
    if (argc <= 1)
    {
        MAX_SIZE = 1001; // Must be an odd number.
    }
    else
    {
        int success = sscanf(argv[1], "%d", &MAX_SIZE);
        if (success == 0)
        {
            printf("Getting user input was unsuccessful.\n");
            return 1;
        }
        else if (MAX_SIZE % 2 == 0)
        {
            MAX_SIZE ++;
            printf("The Maximum Size must be an odd number. Using %d as input instead.\n", MAX_SIZE);
        }
    }

    for (itter = 3; itter <= MAX_SIZE; itter += 2)
    {
        sum += 4 * itter * itter - 6 * (itter - 1);
    }

    printf("Problem 28: %lu | MAX_SIZE: %d\n", sum, MAX_SIZE);
    return 0;
}

